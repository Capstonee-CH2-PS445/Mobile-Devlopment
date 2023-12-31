package com.example.readrave.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.readrave.R
import com.example.readrave.ViewModelFactory
import com.example.readrave.databinding.ActivitySearchBookBinding
import com.example.readrave.ui.adapter.BookAdapter
import com.example.readrave.ui.bookmark.BookmarkActivity
import com.example.readrave.ui.detail.DetailBookActivity
import com.example.readrave.ui.main.MainActivity
import com.example.readrave.ui.profile.ProfileActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBookBinding

    private val viewModel by viewModels<SearchViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchBooks()

        showAllBooks()

        clickButton()
    }

    private fun showAllBooks(){
        val adapter = BookAdapter{ books ->
            val intent = Intent(this, DetailBookActivity::class.java)
            intent.putExtra(DetailBookActivity.BOOK_ID, books.id)
            startActivity(intent)
        }

        binding.rvAllBook.adapter = adapter
        binding.rvAllBook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.getAllBooks().observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }

    private fun searchBooks(){
        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBar.text = searchView.text
                    searchView.hide()
                    viewModel.search(searchView.text.toString())
                    false
                }
        }
    }

    private fun clickButton(){
        val bottomNavView: BottomNavigationView = binding.bottomNavigationView
        bottomNavView.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bookmark -> {
                    val intent = Intent(this, BookmarkActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}