package me.dio.copa.catar.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.domain.model.Team
import me.dio.copa.catar.extensions.LightDarkPreview
import me.dio.copa.catar.ui.theme.AppTheme

@Composable
fun TeamItem(team: Team, isSecondTeam: Boolean = false) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (isSecondTeam) {
            Text(
                text = team.displayName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = team.flag,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.headlineMedium
            )
        } else {
            Text(
                text = team.flag,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = team.displayName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@LightDarkPreview
@Composable
fun FirstTeamItemPreview(
    @PreviewParameter(MatchPreviewDataProvider::class) match: Match
) {
    AppTheme {
        Column {
            TeamItem(team = match.team1)
        }
    }
}

@LightDarkPreview
@Composable
fun SecondTeamItemPreview(
    @PreviewParameter(MatchPreviewDataProvider::class) match: Match
) {
    AppTheme {
        Column {
            TeamItem(team = match.team2, true)
        }
    }
}
