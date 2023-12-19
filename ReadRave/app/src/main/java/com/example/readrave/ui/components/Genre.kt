package com.example.readrave.ui.components

import com.example.readrave.R

data class Genre(
    val name: String,
    val imageResourceId: Int
)

val genreItemList = listOf(
    Genre("Horror", R.drawable.horror_icon),
    Genre("Fantasy", R.drawable.fantasy_icon),
    Genre("Fiksi", R.drawable.fiksi_icon),
    Genre("Romance", R.drawable.romance_icon),
)