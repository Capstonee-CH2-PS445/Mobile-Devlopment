package com.example.readrave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.readrave.R

@Composable
fun GenreRow(
    listGenre: List<Genre>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(listGenre, key = { it.name }) { genre ->
            GenreItem(genre)
        }
    }
}

@Composable
fun GenreItem(
    genre: Genre,
    modifier: Modifier = Modifier,
) {
    Card (
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.green)
        ),
        modifier = modifier.height(100.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth().fillMaxHeight()
        ){
            Text(
                text = genre.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = modifier.width(250.dp).padding(start = 15.dp)
            )
            Image(
                painter = painterResource(genre.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun GenreRowPreview() {
    MaterialTheme {
        GenreRow(genreItemList)
    }
}

@Composable
@Preview(showBackground = true)
fun GenreItemPreview() {
    MaterialTheme {
        GenreItem(
            genre = Genre("Horror",R.drawable.horror_icon)
        )
    }
}