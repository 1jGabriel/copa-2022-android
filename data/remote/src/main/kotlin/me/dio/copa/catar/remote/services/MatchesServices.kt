package me.dio.copa.catar.remote.services

import me.dio.copa.catar.remote.model.GroupRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchesServices {
    @GET("{group}")
    suspend fun getMatches(@Path("group") group: String): GroupRemote
}
