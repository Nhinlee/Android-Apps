package com.nhinlechi.nhin_music_app.ui.screen

import androidx.annotation.StringRes
import com.nhinlechi.nhin_music_app.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home_screen", R.string.home_screen_title)
    object Search : Screen("search_screen", R.string.search_screen_title)
    object Library : Screen("library_screen", R.string.search_screen_title)
}