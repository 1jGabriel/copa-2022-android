package me.dio.copa.catar.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.dio.copa.catar.domain.extensions.getDate
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.extensions.LightDarkPreview
import me.dio.copa.catar.ui.theme.AppTheme

@Composable
fun MatchTitle(match: Match) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = match.stadium.name,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = match.date.getDate(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@LightDarkPreview
@Composable
fun MatchTitlePreview(
    @PreviewParameter(MatchPreviewDataProvider::class) match: Match
) {
    AppTheme {
        MatchTitle(match = match)
    }
}