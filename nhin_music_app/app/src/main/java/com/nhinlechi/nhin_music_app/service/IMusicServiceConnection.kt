package com.nhinlechi.nhin_music_app.service

import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.lifecycle.LiveData

interface IMusicServiceConnection {

    val isConnected: LiveData<Boolean>
    val playbackState: LiveData<PlaybackStateCompat>
    val transportControls: MediaControllerCompat.TransportControls

    fun subscribe(parentId: String, callback: MediaBrowserCompat.SubscriptionCallback)
    fun unsubscribe(parentId: String, callback: MediaBrowserCompat.SubscriptionCallback)
}