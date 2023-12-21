package com.example.readrave.data.repository

import android.util.Log
import androidx.lifecycle.liveData
import com.example.readrave.data.api.ApiService
import com.example.readrave.data.response.LoginResponse
import com.example.readrave.data.response.RegisterResponse
import com.example.readrave.ui.components.Book
import com.example.readrave.ui.components.dummyBook
import com.example.readrave.data.result.Result
import com.example.readrave.ui.components.topBook
import com.google.gson.Gson
import retrofit2.HttpException

class Repository (
    private val apiService: ApiService
){

    fun register(name: String, email: String, password: String, confPassword: String) = liveData {
        emit(Result.Loading)
        try {
            val success = apiService.register(name, email, password, confPassword)
            emit(Result.Success(success))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val error = Gson().fromJson(errorBody, RegisterResponse::class.java)
            val errorMessage = error?.message ?: "Terjadi kesalahan tidak diketahui"
            emit(Result.Error(errorMessage))
            // Tambahan: Log error untuk pemantauan dan debugging
            Log.e("Repository", "Error in register API: $errorMessage", e)
        } catch (e: Exception) {
            val errorMessage = "Terjadi kesalahan tidak diketahui"
            emit(Result.Error(errorMessage))
            // Tambahan: Log error untuk pemantauan dan debugging
            Log.e("Repository", "Unexpected error in register API: $errorMessage", e)
        }
    }

    fun login(email: String, password: String) = liveData {
        emit(Result.Loading)
        try {
            val success = apiService.login(email, password)
            emit(Result.Success(success))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val error = Gson().fromJson(errorBody, LoginResponse::class.java)
            emit(error.message?.let { Result.Error(it) })
        }
    }
    fun getAllBooks(): List<Book> {
        return dummyBook
    }

    fun getForYourBooks(): List<Book> {
        return dummyBook
    }

    fun getTopBooks(): List<Book>{
        return topBook
    }

    fun getBookById(bookId: String): Book? {
        return dummyBook.find { it.id == bookId }
    }

    fun searchBooks(query: String): List<Book>{
        return dummyBook.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            apiService: ApiService
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(apiService)
            }.also { instance = it }
    }
}