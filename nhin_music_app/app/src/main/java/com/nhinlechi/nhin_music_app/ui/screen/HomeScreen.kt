package com.nhinlechi.nhin_music_app.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.nhinlechi.nhin_music_app.R
import com.nhinlechi.nhin_music_app.ui.general.LocalIconButton
import com.nhinlechi.nhin_music_app.ui.general.Space

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        // TODO: Make row composable for reuse
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            LocalIconButton(
                resId = R.drawable.settings,
                onClick = {},
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        }
        Space(8F)
        // TODO: Make row composable for reuse
        Row(
            horizontalArrangement = Arrangement.Start, modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Popular", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Space(8F)

    }
}