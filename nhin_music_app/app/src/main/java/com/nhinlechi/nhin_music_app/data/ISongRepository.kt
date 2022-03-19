package com.nhinlechi.nhin_music_app.data

import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.flow.Flow

interface ISongRepository {
    fun getSongsByPage(offset: Int, limit: Int): List<Song>
    fun getSongsByPage(offset: Int): Flow<Song>
}