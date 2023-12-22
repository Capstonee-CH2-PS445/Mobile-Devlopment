package com.example.readrave.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.viewModels
import com.example.readrave.R
import com.example.readrave.ViewModelFactory
import com.example.readrave.databinding.ActivityDetailBookBinding
import com.example.readrave.databinding.ActivityMainBinding
import com.example.readrave.ui.bookmark.BookmarkActivity
import com.example.readrave.ui.main.MainActivity
import com.example.readrave.ui.main.MainViewModel
import com.example.readrave.ui.profile.ProfileActivity
import com.example.readrave.ui.search.SearchActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBookBinding
    private val viewModel by viewModels<DetailBookViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookId = intent.getStringExtra(BOOK_ID)

        val book = bookId?.let { viewModel.getBookById(it) }

        if (book != null) {
            // Tampilkan data buku di UI
            binding.ivDetailPhoto.setImageResource(book.image)
            binding.tvDetailTitle.text = book.title
            binding.tvDetailDescription.text = book.description
            // Tambahkan kode untuk menampilkan gambar buku, jika perlu
        } else {
            // Handle jika buku tidak ditemukan
            Toast.makeText(this, "Buku tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish() // Sebaiknya kembali ke layar sebelumnya atau melakukan tindakan lainnya
        }

        giveRating()
        clickButton()
    }

    private fun giveRating(){
        ratingBar = binding.ratingBar
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            // Handle perubahan rating di sini
            Toast.makeText(this, "Rating: $rating", Toast.LENGTH_SHORT).show()
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


    companion object {
        const val BOOK_ID = "book_id"
    }
}