package com.example.readrave.data.api

import com.example.readrave.data.response.BookResponse
import com.example.readrave.data.response.LoginResponse
import com.example.readrave.data.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("regist")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confPassword") confPassword: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("books")
    suspend fun getAllBooks(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20
    ): BookResponse
}