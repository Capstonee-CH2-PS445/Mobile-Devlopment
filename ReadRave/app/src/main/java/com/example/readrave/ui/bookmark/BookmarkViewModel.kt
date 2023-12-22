package com.example.readrave.ui.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.readrave.data.repository.Repository
import com.example.readrave.ui.components.Book

class BookmarkViewModel (private val repository: Repository) : ViewModel() {

    private val _groupedBooks = MutableLiveData<List<Book>>()
    val groupedBooks: LiveData<List<Book>> get() = _groupedBooks

    fun getAllBooks() {
        _groupedBooks.value = repository.getFavoriteBooks()
    }
}