package com.nhinlechi.nhin_music_app.data.local

import com.nhinlechi.nhin_music_app.data.ISongRepository
import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.flow.Flow

class LocalSongRepository : ISongRepository {
    override fun getSongsByPage(offset: Int, limit: Int): List<Song> {
        TODO("Not yet implemented")
    }

    override fun getSongsByPage(offset: Int): Flow<Song> {
        TODO("Not yet implemented")
    }
}