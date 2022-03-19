package com.nhinlechi.nhin_music_app.data.local

import androidx.paging.PagingData
import com.nhinlechi.nhin_music_app.data.ISongRepository
import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.flow.Flow

class LocalSongRepository : ISongRepository {
    override suspend fun getSongsByPage(offset: Int, limit: Int): List<Song> {
        return listOf(
            Song(id = "1", title = "title", desc = "desc"),
            Song(id = "2", title = "title", desc = "desc"),
            Song(id = "3", title = "title", desc = "desc"),
            Song(id = "4", title = "title", desc = "desc"),
            Song(id = "5", title = "title", desc = "desc"),
            Song(id = "6", title = "title", desc = "desc"),
            Song(id = "7", title = "title", desc = "desc"),
            Song(id = "8", title = "title", desc = "desc"),
            Song(id = "9", title = "title", desc = "desc"),
            Song(id = "10", title = "title", desc = "desc"),
        )
    }

    override fun getSongsByPage(): Flow<PagingData<Song>> {
        TODO("Not yet implemented")
    }
}