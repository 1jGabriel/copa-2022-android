package me.dio.copa.catar.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import me.dio.copa.catar.R
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.extensions.LightDarkPreview
import me.dio.copa.catar.features.NotificationOnClick
import me.dio.copa.catar.ui.theme.AppTheme

@Composable
fun Notification(match: Match, onClick: NotificationOnClick) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        val drawable = if (match.notificationEnabled) R.drawable.ic_notifications_active
        else R.drawable.ic_notifications

        Icon(
            painter = painterResource(id = drawable),
            modifier = Modifier.clickable {
                onClick(match)
            },
            contentDescription = null
        )
    }
}

@LightDarkPreview
@Composable
fun NotificationPreview(
    @PreviewParameter(MatchPreviewDataProvider::class) match: Match
) {
    AppTheme {
        Notification(match = match, onClick = {})
    }
}