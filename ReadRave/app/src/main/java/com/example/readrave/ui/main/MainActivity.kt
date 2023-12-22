package com.example.readrave.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.readrave.R
import com.example.readrave.ViewModelFactory
import com.example.readrave.databinding.ActivityMainBinding
import com.example.readrave.ui.adapter.ForYourAdapter
import com.example.readrave.ui.bookmark.BookmarkActivity
import com.example.readrave.ui.detail.DetailBookActivity
import com.example.readrave.ui.profile.ProfileActivity
import com.example.readrave.ui.search.SearchActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        displayForYourBook()
        displayTopBook()

        clickButton()
    }

    private fun displayForYourBook(){
        val adapter = ForYourAdapter{ books ->
            val intent = Intent(this, DetailBookActivity::class.java)
            intent.putExtra(DetailBookActivity.BOOK_ID, books.id)
            startActivity(intent)
        }

        binding.rvForyourBook.adapter = adapter
        binding.rvForyourBook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getForYourBooks()

        viewModel.forYourBooks.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun displayTopBook(){
        val adapter = ForYourAdapter{ books ->
            val intent = Intent(this, DetailBookActivity::class.java)
            intent.putExtra(DetailBookActivity.BOOK_ID, books.id)
            startActivity(intent)
        }

        binding.rvTopBook.adapter = adapter
        binding.rvTopBook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getTopBooks()

        viewModel.topBooks.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun clickButton(){
        val bottomNavView: BottomNavigationView = binding.bottomNavigationView
        bottomNavView.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    // Tidak perlu intent karena sudah berada di MainActivity
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

