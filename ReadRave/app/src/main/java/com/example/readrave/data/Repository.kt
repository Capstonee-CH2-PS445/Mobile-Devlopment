package com.example.readrave.data

import com.example.readrave.ui.components.Book
import com.example.readrave.ui.components.dummyBook

class Repository {
    fun getBooks(): List<Book> {
        return dummyBook
    }

    fun searchBooks(query: String): List<Book>{
        return dummyBook.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }
}