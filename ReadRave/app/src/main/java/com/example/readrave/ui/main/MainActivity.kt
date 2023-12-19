package com.example.readrave.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.readrave.R
import com.example.readrave.databinding.ActivityMainBinding
import com.example.readrave.ui.components.BookColumn
import com.example.readrave.ui.components.HomeSection
import com.example.readrave.ui.components.dummyBook
import com.example.readrave.ui.components.forYourBook
import com.example.readrave.ui.components.topBook
import com.example.readrave.ui.search.SearchActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        // Inisialisasi ComposeView untuk konten utama
        val composeView = ComposeView(this)

        // Set konten Compose ke dalam ComposeView
        composeView.setContent {
            // Panggil Composable untuk konten utama di sini
            MainContent()
        }

        findViewById<FrameLayout>(R.id.container).addView(composeView)

        clickButton()
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

@Composable
fun MainContent() {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
        ) {
                HomeSection(
                    title = stringResource(R.string.sedang_dibaca),
                    content = { BookColumn(dummyBook) }
                )
                HomeSection(
                    title = stringResource(R.string.for_your_book),
                    content = { BookColumn(forYourBook) }
                )
                HomeSection(
                    title = stringResource(R.string.top_book),
                    content = { BookColumn(topBook) }
                )
        }
}

@Composable
@Preview(showBackground = true)
fun MainContentPreview() {
    MaterialTheme {
        MainContent()
    }
}

