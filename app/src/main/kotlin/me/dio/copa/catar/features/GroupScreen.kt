package me.dio.copa.catar.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.dio.copa.catar.composables.MatchInfo
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.domain.model.Stadium
import me.dio.copa.catar.domain.model.Team
import me.dio.copa.catar.extensions.LightDarkPreview
import me.dio.copa.catar.ui.theme.AppTheme
import java.time.LocalDateTime

typealias NotificationOnClick = (match: Match) -> Unit

@Composable
fun GroupScreen(matches: List<Match>, onNotificationClick: NotificationOnClick) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(matches) { match ->
                MatchInfo(match, onNotificationClick)
            }
        }
    }
}

@LightDarkPreview
@Composable
fun GroupScreenPreview() {
    AppTheme {
        GroupScreen(matches = listOf(
            Match(
                id = "",
                stadium = Stadium(
                    "Estadio maneiro",
                    "https://digitalinnovationone.github.io/copa-2022-android/statics/974-stadium.png"
                ),
                team1 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                team2 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                date = LocalDateTime.now(),
            ),
            Match(
                id = "",
                stadium = Stadium(
                    "Estadio maneiro",
                    "https://digitalinnovationone.github.io/copa-2022-android/statics/974-stadium.png"
                ),
                team1 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                team2 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                date = LocalDateTime.now(),
            ),
            Match(
                id = "",
                stadium = Stadium(
                    "Estadio maneiro",
                    "https://digitalinnovationone.github.io/copa-2022-android/statics/974-stadium.png"
                ),
                team1 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                team2 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                date = LocalDateTime.now(),
            ),
            Match(
                id = "",
                stadium = Stadium(
                    "Estadio maneiro",
                    "https://digitalinnovationone.github.io/copa-2022-android/statics/974-stadium.png"
                ),
                team1 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                team2 = Team("\uD83C\uDDF6\uD83C\uDDE6", "Qatar"),
                date = LocalDateTime.now(),
            ),
        ), onNotificationClick = { match -> })
    }

}