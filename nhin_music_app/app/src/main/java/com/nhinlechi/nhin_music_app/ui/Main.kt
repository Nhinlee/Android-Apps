package com.nhinlechi.nhin_music_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nhinlechi.nhin_music_app.R
import com.nhinlechi.nhin_music_app.ui.general.LocalCircleButton
import com.nhinlechi.nhin_music_app.ui.general.Space
import com.nhinlechi.nhin_music_app.ui.screen.HomeScreen
import com.nhinlechi.nhin_music_app.ui.screen.LibraryScreen
import com.nhinlechi.nhin_music_app.ui.screen.Screen
import com.nhinlechi.nhin_music_app.ui.screen.SearchScreen
import com.nhinlechi.nhin_music_app.ui.theme.Nhin_music_appTheme

@Composable
fun Main() {
    val navController = rememberNavController()
    val screens = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Library,
    )

    Nhin_music_appTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    screens.forEach { screen ->
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
                            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                        )
                    }
                }
            }) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                    ) {
                        composable(Screen.Home.route) { HomeScreen(navController = navController) }
                        composable(Screen.Search.route) { SearchScreen(navController = navController) }
                        composable(Screen.Library.route) { LibraryScreen(navController = navController) }
                    }
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
                                LocalCircleButton(resId = R.drawable.devices)
                                LocalCircleButton(resId = R.drawable.play)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainPreview() {
    Main()
}