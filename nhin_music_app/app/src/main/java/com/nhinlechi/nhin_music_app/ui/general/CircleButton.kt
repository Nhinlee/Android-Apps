package com.nhinlechi.nhin_music_app.ui.general

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun LocalCircleButton(resId: Int, onClick: () -> Unit = {}) {
    AbstractCircleButton(
        onClick = onClick
    ) {
        Icon(painter = painterResource(id = resId), contentDescription = null)
    }
}

@Composable
fun NetworkVectorCircleButton(imageVector: ImageVector, onClick: () -> Unit = {}) {
    AbstractCircleButton(
        onClick = onClick
    ) {
        Icon(imageVector = imageVector, contentDescription = null)
    }
}

@Composable
fun AbstractCircleButton(
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier.size(Dp(42F)),
        contentPadding = PaddingValues(Dp(0F)),
        elevation = ButtonDefaults.elevation(Dp(0F))
    ) {
        content()
    }
}