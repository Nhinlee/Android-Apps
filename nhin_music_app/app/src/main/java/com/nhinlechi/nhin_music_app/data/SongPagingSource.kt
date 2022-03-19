package com.nhinlechi.nhin_music_app.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.delay

class SongPagingSource(private val localRepos: ISongRepository) : PagingSource<Int, Song>() {
    override fun getRefreshKey(state: PagingState<Int, Song>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Song> {
        val position = params.key ?: STARTING_PAGING_INDEX
        val data = localRepos.getSongsByPage(
            limit = PAGING_SIZE,
            offset = position
        )
        // TODO: remove this, just for test
        delay(1000)
        val nextKey = if (data.isEmpty()) {
            null
        } else {
            position + (params.loadSize / PAGING_SIZE)
        }

        return LoadResult.Page(
            data = data,
            nextKey = nextKey,
            prevKey = if (position == STARTING_PAGING_INDEX) null else position - 1,
        )
    }

    companion object {
        const val PAGING_SIZE = 20
        const val STARTING_PAGING_INDEX = 0
    }
}