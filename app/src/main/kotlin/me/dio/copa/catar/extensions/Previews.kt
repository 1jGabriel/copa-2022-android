package me.dio.copa.catar.extensions

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(name="Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(name="Light theme", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
annotation class LightDarkPreview