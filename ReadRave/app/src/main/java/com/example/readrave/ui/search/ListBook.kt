package com.example.readrave.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.readrave.R
import com.example.readrave.ui.components.Book
import com.example.readrave.ui.components.Genre
import com.example.readrave.ui.components.topBook

@Composable
fun BooksListItem(
    name: String,
    photoUrl: Int,
    description: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = modifier
            .height(170.dp)
            .paddingFromBaseline(4.dp)
            .border(0.3.dp, Color.Gray)
    ) {
        Image(
            painter = painterResource(photoUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(170.dp)
                .width(100.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 10.dp)
            )
            Text(
                text = description,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(end = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BooksListItemPreview() {
    MaterialTheme {
        BooksListItem(
            name = "Laskar Pelangi",
            photoUrl = R.drawable.book2,
            description = "ini adalah buku laskar pelangi",
        )
    }
}