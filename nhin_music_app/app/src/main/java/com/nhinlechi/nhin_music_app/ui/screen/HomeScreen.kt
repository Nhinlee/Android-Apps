package com.nhinlechi.nhin_music_app.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.nhinlechi.nhin_music_app.R
import com.nhinlechi.nhin_music_app.ui.component.HitPlayListItem
import com.nhinlechi.nhin_music_app.ui.general.LocalIconButton
import com.nhinlechi.nhin_music_app.ui.general.Space

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController? = null) {
    val hitPlayListItems = listOf(
        "2022 hit songs",
        "I love you guys",
        "Ok Ok i’m find maybe",
        "Hit hit hit",
        "Hit hit hit",
        "Anyways Anyways Anyways Anyways Anyways",
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        // TODO: Make row composable for reuse
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            LocalIconButton(
                resId = R.drawable.settings,
                onClick = {},
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        }
        Space(height = 8F)
        // TODO: Make row composable for reuse
        Row(
            horizontalArrangement = Arrangement.Start, modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Popular", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Space(height = 8F)
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 150.dp),
            modifier = Modifier.padding(12.dp),
        ) {
            items(hitPlayListItems.size) { index ->
                Box(Modifier.padding(vertical = 4.dp, horizontal = 4.dp)) {
                    HitPlayListItem(label = hitPlayListItems[index])
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = null)
}