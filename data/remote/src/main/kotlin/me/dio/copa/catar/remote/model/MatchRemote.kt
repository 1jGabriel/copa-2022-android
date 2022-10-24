package me.dio.copa.catar.remote.model

import java.util.*

data class MatchRemote(
    val stadium: StadiumRemote,
    val team1: TeamRemote,
    val team2: TeamRemote,
    val date: Date
)