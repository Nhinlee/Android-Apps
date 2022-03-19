package com.nhinlechi.nhin_music_app.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.flow.Flow

class SongRepository(
    private val localRepos: ISongRepository,
    private val remoteRepos: ISongRepository,
) : ISongRepository {
    override suspend fun getSongsByPage(offset: Int, limit: Int): List<Song> {
        return localRepos.getSongsByPage(offset = offset, limit = limit)
    }

    override fun getSongsByPage(): Flow<PagingData<Song>> {
        Log.d(tag, "getSongsByPage")
        return Pager(
            config = PagingConfig(
                pageSize = SongPagingSource.PAGING_SIZE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { SongPagingSource(localRepos = localRepos) }
        ).flow
    }

    companion object {
        val tag: String = "$SongRepository"
    }
}