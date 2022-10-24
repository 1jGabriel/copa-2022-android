package me.dio.copa.catar.remote.mapper

import me.dio.copa.catar.domain.model.*
import me.dio.copa.catar.remote.model.*
import me.dio.copa.catar.remote.model.MatchRemote
import me.dio.copa.catar.remote.model.RoundRemote
import me.dio.copa.catar.remote.model.StadiumRemote
import java.time.ZoneId
import java.util.Date

internal fun List<MatchRemote>.toDomain() = map { it.toDomain() }

@JvmName("toDomainRoundRemote")
internal fun List<RoundRemote>.toDomain(): List<Round> = map { it.toDomain() }

fun GroupRemote.toDomain() = Group(rounds = rounds.toDomain())

fun RoundRemote.toDomain() = Round(name = name, matches = matches.toDomain())
fun MatchRemote.toDomain() = Match(
    id = "$team1-$team2",
    team1 = team1.toDomain(),
    team2 = team2.toDomain(),
    stadium = stadium.toDomain(),
    date = date.toLocalDateTime(),
)

fun TeamRemote.toDomain() = Team(flag = flag, displayName = name)

private fun Date.toLocalDateTime() = toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()

fun StadiumRemote.toDomain() = Stadium(
    name = name,
    image = image
)
