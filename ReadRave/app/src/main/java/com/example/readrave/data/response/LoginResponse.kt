package com.example.readrave.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("msg")
	val message: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("accessToken")
	val accessToken: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
