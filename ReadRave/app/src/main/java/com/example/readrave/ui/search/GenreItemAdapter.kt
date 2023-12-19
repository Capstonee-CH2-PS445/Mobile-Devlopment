package com.example.readrave.ui.search

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.readrave.R
import com.example.readrave.ui.components.GenreItem

//class GenreItemAdapter(private val context: Context, private val genreList: List<GenreItem>) {
//
//    fun addGenreItems(tableLayout: TableLayout) {
//        for (genreItem in genreList) {
//            val cardView = createCardView(genreItem)
//            val tableRow = createTableRow(cardView)
//
//            tableLayout.addView(tableRow)
//        }
//    }
//
//    private fun createCardView(genreItem: GenreItem): CardView {
//        val cardView = CardView(context)
//        // Inflate layout and set data to views inside cardView (similar to your layout)
//        val inflater = LayoutInflater.from(context)
//        val cardViewLayout = inflater.inflate(R.layout.genre_item_layout, cardView, false) as ConstraintLayout
//
//        val tvItemName: TextView = cardViewLayout.findViewById(R.id.tv_item_name)
//        val imgItemPhoto: ImageView = cardViewLayout.findViewById(R.id.img_item_photo)
//
//        tvItemName.text = genreItem.name
//        imgItemPhoto.setImageResource(genreItem.imageResourceId)
//
//        cardView.addView(cardViewLayout)
//
//        return cardView
//    }
//
//    private fun createTableRow(cardView: CardView): TableRow {
//        val tableRow = TableRow(context)
//        val params = TableRow.LayoutParams(
//            TableRow.LayoutParams.WRAP_CONTENT,
//            TableRow.LayoutParams.WRAP_CONTENT
//        )
//        tableRow.layoutParams = params
//        tableRow.addView(cardView)
//        return tableRow
//    }
//}