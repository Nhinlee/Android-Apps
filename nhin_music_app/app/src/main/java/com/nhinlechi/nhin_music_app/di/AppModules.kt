package com.nhinlechi.nhin_music_app.di

import android.content.ComponentName
import android.content.Context
import com.nhinlechi.nhin_music_app.data.ISongRepository
import com.nhinlechi.nhin_music_app.data.SongRepository
import com.nhinlechi.nhin_music_app.data.local.LocalSongRepository
import com.nhinlechi.nhin_music_app.data.remote.RemoteSongRepository
import com.nhinlechi.nhin_music_app.service.IMusicServiceConnection
import com.nhinlechi.nhin_music_app.service.MediaPlaybackService
import com.nhinlechi.nhin_music_app.service.MusicServiceConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    var songRepository: ISongRepository? = null
    var musicServiceConnection: IMusicServiceConnection? = null

    // TODO: why singleton annotation but still need check field is null?
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

    @Singleton
    @Provides
    fun defaultMusicServiceConnection(context: Context): IMusicServiceConnection {
        synchronized(this) {
            return musicServiceConnection ?: MusicServiceConnection(
                context = context,
                serviceComponent = ComponentName(context, MediaPlaybackService::class.java),
            )
        }
    }
}