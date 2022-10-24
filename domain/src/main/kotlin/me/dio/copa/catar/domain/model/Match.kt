package me.dio.copa.catar.domain.model

import java.time.LocalDateTime

data class Match(
    val id: String,
    val stadium: Stadium,
    val team1: Team,
    val team2: Team,
    val date: LocalDateTime,
    var notificationEnabled: Boolean = false,
)
