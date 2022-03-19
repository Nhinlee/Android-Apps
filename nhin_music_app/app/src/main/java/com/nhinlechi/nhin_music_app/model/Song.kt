package com.nhinlechi.nhin_music_app.model

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "desc") val desc: String = "",
    @ColumnInfo(name = "avatar") val avatar: String = "",
    @ColumnInfo(name = "uri") val uri: Uri = Uri.EMPTY,
)
