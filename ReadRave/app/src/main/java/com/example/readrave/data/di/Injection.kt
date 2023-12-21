package com.example.readrave.data.di

import android.content.Context
import com.example.readrave.data.api.ApiConfig
import com.example.readrave.data.repository.Repository

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService)
    }
}