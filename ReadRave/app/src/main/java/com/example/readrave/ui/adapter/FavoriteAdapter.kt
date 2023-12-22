package com.example.readrave.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.compose.AsyncImage
import com.example.readrave.data.response.ListbookItem
import com.example.readrave.databinding.SearchBookItemBinding
import com.example.readrave.ui.components.Book

class FavoriteAdapter(private val onItemClick: (Book) -> Unit) : ListAdapter<Book, FavoriteAdapter.MyViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = SearchBookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding, onItemClick)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int, ) {
        val book = getItem(position)
        holder.bind(book)
    }

    class MyViewHolder(
        private val binding: SearchBookItemBinding,
        val onItemClick: (Book) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book){
            binding.composeView.setContent {
                MaterialTheme {
                    FavoriteListItem(
                        book,
                        onItemClick = { onItemClick(book) })
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


@Composable
fun FavoriteListItem(
    book: Book,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Card (
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(150.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = book.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                    Text(
                        text = book.title,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
                    Text(
                        text = book.description,
                        fontWeight = FontWeight.Normal,
                        maxLines = 2,
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(end = 10.dp)
                    )
                }
            }
        }