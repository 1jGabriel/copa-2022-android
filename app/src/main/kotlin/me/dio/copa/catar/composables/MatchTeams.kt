package me.dio.copa.catar.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.extensions.LightDarkPreview
import me.dio.copa.catar.ui.theme.AppTheme

@Composable
fun MatchTeams(match: Match) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TeamItem(team = match.team1)

        Text(
            text = "X",
            modifier = Modifier.padding(end = 16.dp, start = 16.dp),
            style = MaterialTheme.typography.bodySmall
        )

        TeamItem(team = match.team2, true)
    }
}

@LightDarkPreview
@Composable
fun MatchTeamsPreview(
    @PreviewParameter(MatchPreviewDataProvider::class) match: Match
) {
    AppTheme {
        MatchTeams(match = match)
    }
}