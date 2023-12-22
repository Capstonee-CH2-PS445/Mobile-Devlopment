package com.example.readrave.data.response

import com.google.gson.annotations.SerializedName

data class BookResponse(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("listbook")
	val listbook: List<ListbookItem>
)

data class ListbookItem(

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("isbn")
	val isbn: Int? = null,

	@field:SerializedName("average_rating")
	val averageRating: Any? = null,

	@field:SerializedName("id_user")
	val idUser: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("book_id")
	val bookId: Int? = null,

	@field:SerializedName("original_publication_year")
	val originalPublicationYear: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("ratings_count")
	val ratingsCount: Int? = null,

	@field:SerializedName("authors")
	val authors: String? = null
)
