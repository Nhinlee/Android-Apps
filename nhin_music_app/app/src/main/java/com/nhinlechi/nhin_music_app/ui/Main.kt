package com.nhinlechi.nhin_music_app.ui

import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nhinlechi.nhin_music_app.R
import com.nhinlechi.nhin_music_app.domain.SongsViewModel
import com.nhinlechi.nhin_music_app.ui.container.SongPlayerContainer
import com.nhinlechi.nhin_music_app.ui.screen.HomeScreen
import com.nhinlechi.nhin_music_app.ui.screen.LibraryScreen
import com.nhinlechi.nhin_music_app.ui.screen.Screen
import com.nhinlechi.nhin_music_app.ui.screen.SearchScreen
import com.nhinlechi.nhin_music_app.ui.theme.Nhin_music_appTheme

@ExperimentalFoundationApi
@Composable
fun Main(songsViewModel: SongsViewModel, mediaController: MediaControllerCompat? = null) {
    val navController = rememberNavController()
    val screens = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Library,
    )
    val resources = listOf(
        R.drawable.home,
        R.drawable.search,
        R.drawable.library,
    )
    val bottomTabLabels = listOf(
        "Home",
        "Search",
        "Library",
    )

    Nhin_music_appTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    screens.forEach { screen ->
                        val currentIndex = screens.indexOf(screen)
                        //
                        BottomNavigationItem(
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(
                                        id = resources[currentIndex]
                                    ),
                                    contentDescription = null
                                )
                            },
                            label = { Text(text = bottomTabLabels[currentIndex], fontSize = 12.sp) }
                        )
                    }
                }
            }) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth(Alignment.Start)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Home.route,
                        ) {
                            composable(Screen.Home.route) { HomeScreen(navController = navController) }
                            composable(Screen.Search.route) {
                                SearchScreen(
                                    navController = navController,
                                    songsViewModel = songsViewModel
                                )
                            }
                            composable(Screen.Library.route) { LibraryScreen(navController = navController) }
                        }
                    }
                    Box {
                        SongPlayerContainer(
                            onPlayClick = {
                                if (mediaController == null) return@SongPlayerContainer

                                val pbState = mediaController.playbackState.state
                                if (pbState == PlaybackStateCompat.STATE_PLAYING) {
                                    mediaController.transportControls.pause()
                                } else {
                                    mediaController.transportControls.play()
                                }

                                // Display the initial state
                                val metadata = mediaController.metadata
                            },
                        )
                    }
//
                }
            }
        }
    }
}

// TODO: ViewModel issues
//@ExperimentalFoundationApi
//@Preview
//@Composable
//fun MainPreview() {
//    Main()
//}