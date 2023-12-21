package com.example.readrave.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.readrave.data.repository.Repository
import com.example.readrave.ui.components.Book

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _forYourBooks = MutableLiveData<List<Book>>()
    val forYourBooks: LiveData<List<Book>> get() = _forYourBooks

    private val _topBooks = MutableLiveData<List<Book>>()
    val topBooks: LiveData<List<Book>> get() = _topBooks

    fun getForYourBooks() {
        _forYourBooks.value = repository.getForYourBooks()
    }

    fun getTopBooks() {
        _topBooks.value = repository.getTopBooks()
    }
}