package me.dio.copa.catar.remote.source

import me.dio.copa.catar.data.source.MatchesDataSource
import me.dio.copa.catar.domain.model.Group
import me.dio.copa.catar.remote.extensions.getOrThrowDomainError
import me.dio.copa.catar.remote.mapper.toDomain
import me.dio.copa.catar.remote.services.MatchesServices
import javax.inject.Inject

class MatchDataSourceRemote @Inject constructor(
    private val service: MatchesServices
) : MatchesDataSource.Remote {

    override suspend fun getMatches(group: String): Group {
        return runCatching {
            service.getMatches(group)
        }.getOrThrowDomainError().toDomain()
    }
}
