package com.example.readrave.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.readrave.databinding.BookItemLayoutBinding
import com.example.readrave.ui.components.Book

class BookAdapter : ListAdapter<Book, BookAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = BookItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int, ) {
        val user = getItem(position)
        holder.bind(user)

//        holder.itemView.setOnClickListener {
//            val user = getItem(position)
//            val intent = Intent(holder.itemView.context, DetailUserActivity::class.java)
//            intent.putExtra("USERNAME", user.login)
//
//            val intent2 = Intent(holder.itemView.context, SectionsPagerAdapter::class.java)
//            intent2.putExtra("USERNAME", user.login)
//            holder.itemView.context.startActivity(intent)
//        }
    }

    class MyViewHolder(val binding: BookItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book){
            binding.tvItemName.text = book.title
            binding.tvItemDescription.text = book.description
            Glide.with(binding.imgItemPhoto).load(book.image).transform(CircleCrop()).into(binding.imgItemPhoto)
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