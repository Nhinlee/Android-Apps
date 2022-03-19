package com.nhinlechi.nhin_music_app.data.remote

import androidx.paging.PagingData
import com.nhinlechi.nhin_music_app.data.ISongRepository
import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.flow.Flow

class RemoteSongRepository : ISongRepository {
    override suspend fun getSongsByPage(offset: Int, limit: Int): List<Song> {
        TODO("Not yet implemented")
    }

    override fun getSongsByPage(): Flow<PagingData<Song>> {
        TODO("Not yet implemented")
    }
}