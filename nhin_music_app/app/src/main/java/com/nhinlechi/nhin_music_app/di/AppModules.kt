package com.nhinlechi.nhin_music_app.di

import com.nhinlechi.nhin_music_app.data.ISongRepository
import com.nhinlechi.nhin_music_app.data.SongRepository
import com.nhinlechi.nhin_music_app.data.local.LocalSongRepository
import com.nhinlechi.nhin_music_app.data.remote.RemoteSongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    var songRepository: ISongRepository? = null

    @Singleton
    @Provides
    fun defaultSongRepository(): ISongRepository {
        synchronized(this) {
            return songRepository ?: createSongRepository()
        }
    }

    private fun createSongRepository(): ISongRepository {
        songRepository = SongRepository(
            localRepos = LocalSongRepository(),
            remoteRepos = RemoteSongRepository(),
        )
        return songRepository!!
    }
}