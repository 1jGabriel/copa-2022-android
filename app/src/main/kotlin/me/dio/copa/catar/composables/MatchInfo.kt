package me.dio.copa.catar.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.extensions.LightDarkPreview
import me.dio.copa.catar.features.NotificationOnClick
import me.dio.copa.catar.ui.theme.AppTheme
import me.dio.copa.catar.ui.theme.Shapes

@Composable
fun MatchInfo(match: Match, onNotificationClick: NotificationOnClick) {
    Card(
        shape = Shapes.medium,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box {
            AsyncImage(
                model = match.stadium.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(160.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Notification(match, onNotificationClick)
                MatchTitle(match)
                MatchTeams(match)
            }
        }
    }
}

@LightDarkPreview
@Composable
fun MatchInfoPreview(
    @PreviewParameter(MatchPreviewDataProvider::class) match: Match
) {
    AppTheme {
        MatchInfo(match = match, onNotificationClick = {})
    }
}

