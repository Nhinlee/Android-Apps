package com.nhinlechi.nhin_music_app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nhinlechi.nhin_music_app.ui.screen.HomeScreen
import com.nhinlechi.nhin_music_app.ui.screen.LibraryScreen
import com.nhinlechi.nhin_music_app.ui.screen.Screen
import com.nhinlechi.nhin_music_app.ui.screen.SearchScreen
import com.nhinlechi.nhin_music_app.ui.theme.Nhin_music_appTheme
import com.nhinlechi.nhin_music_app.ui.theme.dark

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
                Box {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Home.route) { HomeScreen(navController = navController) }
                        composable(Screen.Search.route) { SearchScreen(navController = navController) }
                        composable(Screen.Library.route) { LibraryScreen(navController = navController) }
                    }
                    Spacer(
                        modifier = Modifier
                            .matchParentSize()
                            .background(dark).align(Alignment.BottomCenter)
                    )
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