package com.example.readrave

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.readrave.data.Repository
import com.example.readrave.ui.search.SearchViewModel

class ViewModelFactory (private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(repository) as T
        }
//        else if (modelClass.isAssignableFrom(DetailPlayerViewModel::class.java)) {
//            return DetailPlayerViewModel(repository) as T
//        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(repository = Repository())
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}