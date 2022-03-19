package com.nhinlechi.nhin_music_app.data.local

import androidx.room.Dao
import androidx.room.Query
import com.nhinlechi.nhin_music_app.model.Song

@Dao
interface SongsDAO {
    @Query("select * from Song where id = :id")
    fun getSongById(id: String): Song

    @Query("select * from Song limit :limit offset :offset")
    fun getSongs(offset: Int, limit: Int): List<Song>
}