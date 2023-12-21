package com.example.readrave.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.readrave.databinding.MainBookItemBinding
import com.example.readrave.ui.components.Book
import com.example.readrave.ui.detail.DetailBookActivity

class TopBookAdapter(private val onItemClick: (Book) -> Unit) : ListAdapter<Book, TopBookAdapter.BookViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = MainBookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = getItem(position)
        holder.bind(book)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailBookActivity::class.java)
            intentDetail.putExtra("book_id", book.id)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class BookViewHolder(
        private val binding: MainBookItemBinding,
        val onItemClick: (Book) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.composeView.setContent {
                MaterialTheme {
                    BookItem(
                        book,
                        onItemClick = { onItemClick(book) }
                    )
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }
        }
    }
}