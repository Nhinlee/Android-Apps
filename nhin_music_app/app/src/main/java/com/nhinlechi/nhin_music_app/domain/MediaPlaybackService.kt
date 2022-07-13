package com.nhinlechi.nhin_music_app.domain

import android.app.PendingIntent
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.media.MediaBrowserServiceCompat

class MediaPlaybackService : MediaBrowserServiceCompat() {

    private var mediaSession: MediaSessionCompat? = null
    private lateinit var stateBuilder: PlaybackStateCompat.Builder

    override fun onCreate() {
        super.onCreate()

        // Build a PendingIntent that can be used to launch the UI.
        val sessionActivityPendingIntent =
            packageManager?.getLaunchIntentForPackage(packageName)?.let { sessionIntent ->
                PendingIntent.getActivity(this, 0, sessionIntent, 0)
            }

        mediaSession = MediaSessionCompat(baseContext, Tag).apply {

            // TODO: test this behavior
            setSessionActivity(sessionActivityPendingIntent)

            // TODO: test this behavior
            isActive = true

            // Set an initial PlaybackState with ACTION_PLAY, so media buttons can start the player
            stateBuilder = PlaybackStateCompat.Builder()
                .setActions(
                    PlaybackStateCompat.ACTION_PLAY
                            or PlaybackStateCompat.ACTION_PLAY_PAUSE
                )
            setPlaybackState(stateBuilder.build())

            // MySessionCallback() has methods that handle callbacks from a media controller
            setCallback(MySessionCallback())

            // Set the session's token so that client activities can communicate with it.
            setSessionToken(sessionToken)
        }
    }

    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot {
        // (Optional) Control the level of access for the specified package name.
        // You'll need to write your own logic to do this.
        return if (allowBrowsing(clientPackageName, clientUid)) {
            // Returns a root ID that clients can use with onLoadChildren() to retrieve
            // the content hierarchy.
            BrowserRoot(rootID, null)
        } else {
            // Clients can connect, but this BrowserRoot is an empty hierarchy
            // so onLoadChildren returns nothing. This disables the ability to browse for content.
            BrowserRoot(rootEmptyId, null)
        }
    }

    private fun allowBrowsing(clientPackageName: String, clientUid: Int): Boolean {
        // TODO: implement logic check allowBrowsing here
        return true
    }

    override fun onLoadChildren(
        parentId: String,
        result: Result<MutableList<MediaBrowserCompat.MediaItem>>
    ) {
        //  Browsing not allowed
        if (rootEmptyId == parentId) {
            result.sendResult(null)
            return
        }

        // Assume for example that the music  is already loaded/cached.
        val mediaItems = mutableListOf<MediaBrowserCompat.MediaItem>()

        // Check if this is the root menu:
        if (rootID == parentId) {
            // Build the MediaItem objects for the top level,
            // and put them in the mediaItems list...
        } else {
            // Examine the passed parentMediaId to see which submenu we're at,
            // and put the children of that menu in the mediaItems list...
        }
        result.sendResult(mediaItems)
    }

    override fun onDestroy() {
        mediaSession?.run {
            isActive = false
        }
        super.onDestroy()
    }

    companion object {
        const val Tag = "MediaPlaybackService - Nhin Pro"
        const val rootID = "MY_MEDIA_ROOT_ID"
        const val rootEmptyId = "MY_EMPTY_MEDIA_ROOT_ID"
    }
}

class MySessionCallback : MediaSessionCompat.Callback() {

}
