package com.nhinlechi.nhin_music_app.data

import android.util.Log
import com.nhinlechi.nhin_music_app.model.Song
import kotlinx.coroutines.flow.Flow

class SongRepository(
    private val localRepos: ISongRepository,
    private val remoteRepos: ISongRepository,
) : ISongRepository {
    override fun getSongsByPage(offset: Int, limit: Int): List<Song> {
        TODO("Not yet implemented")
    }

    override fun getSongsByPage(offset: Int): Flow<Song> {
        Log.d(tag, "getSongsByPage")
        return localRepos.getSongsByPage(offset = offset)
    }

    companion object {
        val tag: String = "$SongRepository"
    }
}