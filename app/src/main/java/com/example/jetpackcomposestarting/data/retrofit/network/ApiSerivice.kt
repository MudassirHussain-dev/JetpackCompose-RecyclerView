package com.example.jetpackcomposestarting.data.retrofit.network

import com.example.jetpackcomposestarting.data.retrofit.Post
import retrofit2.http.GET

interface ApiSerivice {
    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPost(): List<Post>

}