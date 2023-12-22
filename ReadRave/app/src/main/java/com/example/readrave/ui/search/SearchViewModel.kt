package com.example.readrave.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.readrave.data.repository.Repository
import com.example.readrave.data.response.ListbookItem
import com.example.readrave.ui.components.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel (private val repository: Repository) : ViewModel() {

    private val _groupedBooks = MutableLiveData<List<Book>>()
    val groupedBooks: LiveData<List<Book>> get() = _groupedBooks

    fun getForYourBooks() {
        _groupedBooks.value = repository.getForYourBooks()
    }

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedBooks.value = repository.searchBooks(_query.value)
    }

    fun getAllBooks(): LiveData<PagingData<ListbookItem>> =
        repository.getAllBooks().cachedIn(viewModelScope)
}