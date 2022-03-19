package com.nhinlechi.nhin_music_app.domain

import androidx.lifecycle.ViewModel
import com.nhinlechi.nhin_music_app.data.ISongRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SongsViewModel @Inject constructor(
    private val SongRepository: ISongRepository
) : ViewModel() {
}