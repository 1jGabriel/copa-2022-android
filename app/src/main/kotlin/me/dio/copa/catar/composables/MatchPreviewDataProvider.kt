package me.dio.copa.catar.composables

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.domain.model.Stadium
import me.dio.copa.catar.domain.model.Team
import java.time.LocalDateTime

class MatchPreviewDataProvider : PreviewParameterProvider<Match> {
    override val values: Sequence<Match>
        get() = sequenceOf(
            Match(
                id = "",
                stadium = Stadium(
                    "Estadio maneiro",
                    "https://digitalinnovationone.github.io/copa-2022-android/statics/974-stadium.png"
                ),
                team1 = Team("\uD83C\uDDE7\uD83C\uDDF7", "Brasil"),
                team2 = Team("\uD83C\uDDEB\uD83C\uDDF7", "França"),
                date = LocalDateTime.now(),
            )
        )
}