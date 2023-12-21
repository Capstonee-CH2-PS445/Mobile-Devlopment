package com.example.readrave.ui.detail

import androidx.lifecycle.ViewModel
import com.example.readrave.data.repository.Repository
import com.example.readrave.ui.components.Book

class DetailBookViewModel(private val repository: Repository) : ViewModel() {
    fun getBookById(bookId: String): Book? {
        return repository.getBookById(bookId)
    }
}