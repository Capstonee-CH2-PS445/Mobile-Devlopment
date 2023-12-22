package com.example.readrave.data.favorite

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.githubuserapp.data.database.FavoriteBook
import com.example.githubuserapp.data.database.FavoriteDao
import com.example.githubuserapp.data.database.FavoriteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteRepository (application: Application) {
    private val mFavoriteDao: FavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FavoriteRoomDatabase.getDatabase(application)
        mFavoriteDao = db.favoriteDao()
    }


    fun getAllFavorites(): LiveData<List<FavoriteBook>> = mFavoriteDao.getAllFavorites()

    fun getUserFavorite(title: String): FavoriteBook? {
        return mFavoriteDao.getBookFavorite(title)
    }
    fun insert(title: FavoriteBook) {
        executorService.execute { mFavoriteDao.insert(title) }
    }

    fun delete(title: String) {
        executorService.execute { mFavoriteDao.delete(title) }
    }

}