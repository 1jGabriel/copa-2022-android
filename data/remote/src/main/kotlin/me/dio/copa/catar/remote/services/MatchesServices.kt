package me.dio.copa.catar.remote.services

import me.dio.copa.catar.remote.model.GroupRemote
import me.dio.copa.catar.remote.model.MatchRemote
import me.dio.copa.catar.remote.model.RoundRemote
import retrofit2.http.GET

interface MatchesServices {
    @GET("group-a.json")
    suspend fun getMatches(): GroupRemote
}
