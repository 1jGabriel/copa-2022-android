package me.dio.copa.catar.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import me.dio.copa.catar.data.source.MatchesDataSource
import me.dio.copa.catar.domain.model.Group
import me.dio.copa.catar.domain.repositories.MatchesRepository
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val localDataSource: MatchesDataSource.Local,
    private val remoteDataSource: MatchesDataSource.Remote,
) : MatchesRepository {
    override suspend fun getMatches(): Flow<Group> {
        return flowOf(remoteDataSource.getMatches())
            .combine(
                localDataSource.getActiveNotificationIds(),
                transform = { group: Group, ids: Set<String> ->
                    group.rounds
                        .flatMap { it.matches }
                        .forEach {
                            it.notificationEnabled = ids.contains(it.id)
                        }
                    return@combine group
                })

    }

    override suspend fun enableNotificationFor(id: String) {
        localDataSource.enableNotificationFor(id)
    }

    override suspend fun disableNotificationFor(id: String) {
        localDataSource.disableNotificationFor(id)
    }
}
