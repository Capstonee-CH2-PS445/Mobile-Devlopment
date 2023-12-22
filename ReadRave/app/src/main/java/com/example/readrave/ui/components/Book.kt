package com.example.readrave.ui.components

import com.example.readrave.R

data class Book(
    val id: String,
    val image: Int,
    val title: String,
    val description: String
)

val dummyBook = listOf(
    Book("1", R.drawable.book1, "Banyak Bicara Sedikit Bekerja", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consequat nulla felis, id iaculis libero ultrices a. Integer fermentum ligula consequat mollis faucibus. Duis pretium orci sit amet arcu dictum, at pellentesque ante feugiat. Nullam tristique sagittis maximus. Integer quis libero a ex eleifend rutrum. Nullam ornare enim massa, porta accumsan nunc consectetur non. Donec mattis auctor commodo. Vestibulum sollicitudin luctus lacus, sed mollis augue imperdiet quis. Sed vel dignissim ante."),
    Book("2", R.drawable.book2, "Hutan Beton yang Besar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consequat nulla felis, id iaculis libero ultrices a. Integer fermentum ligula consequat mollis faucibus. Duis pretium orci sit amet arcu dictum, at pellentesque ante feugiat. Nullam tristique sagittis maximus. Integer quis libero a ex eleifend rutrum. Nullam ornare enim massa, porta accumsan nunc consectetur non. Donec mattis auctor commodo. Vestibulum sollicitudin luctus lacus, sed mollis augue imperdiet quis. Sed vel dignissim ante."),
    Book("3", R.drawable.book3, "Menua Bersamamu", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consequat nulla felis, id iaculis libero ultrices a. Integer fermentum ligula consequat mollis faucibus. Duis pretium orci sit amet arcu dictum, at pellentesque ante feugiat. Nullam tristique sagittis maximus. Integer quis libero a ex eleifend rutrum. Nullam ornare enim massa, porta accumsan nunc consectetur non. Donec mattis auctor commodo. Vestibulum sollicitudin luctus lacus, sed mollis augue imperdiet quis. Sed vel dignissim ante."),
    Book("4", R.drawable.book4, "Buka Mata & Pikiran", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consequat nulla felis, id iaculis libero ultrices a. Integer fermentum ligula consequat mollis faucibus. Duis pretium orci sit amet arcu dictum, at pellentesque ante feugiat. Nullam tristique sagittis maximus. Integer quis libero a ex eleifend rutrum. Nullam ornare enim massa, porta accumsan nunc consectetur non. Donec mattis auctor commodo. Vestibulum sollicitudin luctus lacus, sed mollis augue imperdiet quis. Sed vel dignissim ante."),
    Book("5", R.drawable.book5, "Perahu Kertas", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consequat nulla felis, id iaculis libero ultrices a. Integer fermentum ligula consequat mollis faucibus. Duis pretium orci sit amet arcu dictum, at pellentesque ante feugiat. Nullam tristique sagittis maximus. Integer quis libero a ex eleifend rutrum. Nullam ornare enim massa, porta accumsan nunc consectetur non. Donec mattis auctor commodo. Vestibulum sollicitudin luctus lacus, sed mollis augue imperdiet quis. Sed vel dignissim ante."),
    Book("6", R.drawable.book6, "Berpikir besar: Melampaui Pasar Lokal", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras consequat nulla felis, id iaculis libero ultrices a. Integer fermentum ligula consequat mollis faucibus. Duis pretium orci sit amet arcu dictum, at pellentesque ante feugiat. Nullam tristique sagittis maximus. Integer quis libero a ex eleifend rutrum. Nullam ornare enim massa, porta accumsan nunc consectetur non. Donec mattis auctor commodo. Vestibulum sollicitudin luctus lacus, sed mollis augue imperdiet quis. Sed vel dignissim ante."),
)

val favoriteBook = dummyBook.shuffled()

val topBook = dummyBook.shuffled()