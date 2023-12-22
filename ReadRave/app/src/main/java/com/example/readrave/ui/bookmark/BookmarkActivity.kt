package com.example.readrave.ui.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.readrave.R
import com.example.readrave.ViewModelFactory
import com.example.readrave.databinding.ActivityBookmarkBinding
import com.example.readrave.databinding.ActivitySearchBookBinding
import com.example.readrave.ui.adapter.BookAdapter
import com.example.readrave.ui.adapter.FavoriteAdapter
import com.example.readrave.ui.detail.DetailBookActivity
import com.example.readrave.ui.main.MainActivity
import com.example.readrave.ui.search.SearchActivity
import com.example.readrave.ui.search.SearchViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class BookmarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookmarkBinding

    private val viewModel by viewModels<BookmarkViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFavoriteBooks()

        clickButton()
    }

    private fun showFavoriteBooks(){
        val adapter = FavoriteAdapter{ books ->
            val intent = Intent(this, DetailBookActivity::class.java)
            intent.putExtra(DetailBookActivity.BOOK_ID, books.id)
            startActivity(intent)
        }

        binding.rvAllBook.adapter = adapter
        binding.rvAllBook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.getAllBooks()

        viewModel.groupedBooks.observe(this) {
            adapter.submitList(it)
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
                    // Tambahkan logika atau intent jika diperlukan
                    true
                }
                else -> false
            }
        }
    }
}