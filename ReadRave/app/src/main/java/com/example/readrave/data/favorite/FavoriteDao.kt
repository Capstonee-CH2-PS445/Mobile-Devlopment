package com.example.githubuserapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(title: FavoriteBook)

    @Update
    fun update(title: FavoriteBook)

    @Query("DELETE FROM favoriteBook WHERE title = :title")
    fun delete(title: String)

    @Query("SELECT * from favoriteBook ORDER BY title ASC")
    fun getAllFavorites(): LiveData<List<FavoriteBook>>

    @Query("SELECT * FROM favoriteBook WHERE title = :title LIMIT 1")
    fun getBookFavorite(title: String) : FavoriteBook?
}