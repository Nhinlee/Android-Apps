package com.nhinlechi.nhin_music_app.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.nhinlechi.nhin_music_app.R
import com.nhinlechi.nhin_music_app.domain.SongsViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    songsViewModel: SongsViewModel,
) {
    val lazySongItems = songsViewModel.getSongs().collectAsLazyPagingItems()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                songsViewModel.getSongs()
            }) {
                Icon(painter = painterResource(id = R.drawable.search), contentDescription = "")
            }
        }
    ) {
        LazyColumn {
            items(lazySongItems) {
                Text("Item is $it")
            }
        }
    }
}