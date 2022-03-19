package com.nhinlechi.nhin_music_app.data

import androidx.paging.PagingData
import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.flow.Flow

interface ISongRepository {
    suspend fun getSongsByPage(offset: Int, limit: Int): List<Song>
    fun getSongsByPage(): Flow<PagingData<Song>>
}