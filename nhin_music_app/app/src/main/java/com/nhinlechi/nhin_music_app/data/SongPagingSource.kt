package com.nhinlechi.nhin_music_app.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nhinlechi.nhin_music_app.model.Song

class SongPagingSource(localRepos: ISongRepository): PagingSource<Int, Song>() {
    override fun getRefreshKey(state: PagingState<Int, Song>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Song> {
        TODO("Not yet implemented")
    }

}