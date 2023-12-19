package com.example.readrave.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.readrave.data.Repository
import com.example.readrave.ui.components.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel (private val repository: Repository) : ViewModel() {

    private val _groupedBooks = MutableStateFlow(
        repository.getBooks()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )
    val groupedBooks: StateFlow<Map<Char, List<Book>>> get() = _groupedBooks

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedBooks.value = repository.searchBooks(_query.value)
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    }
}