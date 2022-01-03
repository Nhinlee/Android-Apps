package com.nhinlechi.nhin_music_app.ui.general

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Space(width: Float? = 0F, height: Float? = 0F) {
    Spacer(
        modifier = Modifier
            .width(Dp(width ?: 0F))
            .height(Dp(height ?: 0F)),
    )
}