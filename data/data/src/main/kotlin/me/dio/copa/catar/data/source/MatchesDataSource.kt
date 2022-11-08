package me.dio.copa.catar.data.source

import kotlinx.coroutines.flow.Flow
import me.dio.copa.catar.domain.model.Group

sealed interface MatchesDataSource {
    interface Remote : MatchesDataSource {
        suspend fun getMatches(group: String): Group
    }

    interface Local : MatchesDataSource {
        fun getActiveNotificationIds(): Flow<Set<String>>
        suspend fun enableNotificationFor(id: String)
        suspend fun disableNotificationFor(id: String)
    }
}
