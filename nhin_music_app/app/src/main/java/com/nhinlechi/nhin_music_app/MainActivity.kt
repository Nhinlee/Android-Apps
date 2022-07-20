package com.nhinlechi.nhin_music_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import com.nhinlechi.nhin_music_app.domain.SongsViewModel
import com.nhinlechi.nhin_music_app.ui.Main
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val songViewModel: SongsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main(songsViewModel = songViewModel)
        }

        // Register callback
        songViewModel.rootMediaId.observe(this) {
            Log.d(Tag, "MainActivity: Root MediaId: $it")
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
//        volumeControlStream = AudioManager.STREAM_MUSIC
    }

    override fun onStop() {
        super.onStop()
    }

    companion object {
        const val Tag = "MainActivity"
    }
}