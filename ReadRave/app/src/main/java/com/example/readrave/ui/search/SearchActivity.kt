package com.example.readrave.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.compose.ui.platform.ComposeView
import com.example.readrave.R
import com.example.readrave.databinding.ActivitySearchBinding
import com.example.readrave.ui.components.GenreRow
import com.example.readrave.ui.components.genreItemList
import com.example.readrave.ui.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val composeView = ComposeView(this)
        composeView.setContent {
            GenreRow(genreItemList)
        }

        findViewById<FrameLayout>(R.id.container).addView(composeView)

        clickButton()

        binding.searchBar.setOnClickListener {
            val intent = Intent(this, SearchBookActivity::class.java)
            startActivity(intent)
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
                    true
                }
                R.id.bookmark -> {
                    // Tambahkan logika atau intent jika diperlukan
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