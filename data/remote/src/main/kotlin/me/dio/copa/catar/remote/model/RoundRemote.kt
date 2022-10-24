package me.dio.copa.catar.remote.model

data class RoundRemote(
    val name: String,
    val matches: List<MatchRemote>
)