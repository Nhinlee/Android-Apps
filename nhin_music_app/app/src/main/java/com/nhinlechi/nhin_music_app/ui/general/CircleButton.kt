package com.nhinlechi.nhin_music_app.ui.general

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun LocalIconButton(
    resId: Int,
    onClick: () -> Unit = {},
    backgroundColor: Color? = null,
) {
    AbstractCircleButton(
        onClick = onClick,
        backgroundColor = backgroundColor,
    ) {
        Icon(painter = painterResource(id = resId), contentDescription = null)
    }
}

@Composable
fun NetworkVectorIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit = {},
    backgroundColor: Color? = null,
) {
    AbstractCircleButton(
        onClick = onClick,
        backgroundColor = backgroundColor
    ) {
        Icon(imageVector = imageVector, contentDescription = null)
    }
}

@Composable
fun AbstractCircleButton(
    onClick: () -> Unit = {},
    backgroundColor: Color? = null,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier.size(Dp(42F)),
        contentPadding = PaddingValues(Dp(0F)),
        elevation = ButtonDefaults.elevation(Dp(0F)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor ?: MaterialTheme.colors.primary
        )
    ) {
        content()
    }
}