package com.nhinlechi.nhin_music_app.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nhinlechi.nhin_music_app.data.ISongRepository
import com.nhinlechi.nhin_music_app.model.Song
import com.nhinlechi.nhin_music_app.service.IMusicServiceConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SongsViewModel @Inject constructor(
    private val songRepository: ISongRepository,
    private val musicServiceConnection: IMusicServiceConnection,
) : ViewModel() {

    val rootMediaId: LiveData<String> =
        Transformations.map(musicServiceConnection.isConnected) { isConnected ->
            if (isConnected) {
                musicServiceConnection.mediaRootId
            } else {
                null
            }
        }

    fun getSongs(): Flow<PagingData<Song>> {
        return songRepository.getSongsByPage().cachedIn(viewModelScope)
    }
}