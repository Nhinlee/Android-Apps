package com.nhinlechi.nhin_music_app.ui.container

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.nhinlechi.nhin_music_app.R
import com.nhinlechi.nhin_music_app.ui.general.LocalIconButton
import com.nhinlechi.nhin_music_app.ui.general.Space

@Composable
fun SongPlayerContainer() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(Dp(60F))
                .background(color = MaterialTheme.colors.primary)
                .fillMaxWidth()
                .border(width = Dp(0.5F), color = MaterialTheme.colors.primaryVariant),
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null
                    )
                    Space(width = 8F)
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text("Chúng ta không thuộc về nhau")
                        Space(width = 8F)
                        Text("Sơn tùng MTP", color = MaterialTheme.colors.onSecondary)
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = Dp(8F))
                ) {
                    LocalIconButton(resId = R.drawable.devices)
                    LocalIconButton(resId = R.drawable.play)
                }
            }
        }
    }
}