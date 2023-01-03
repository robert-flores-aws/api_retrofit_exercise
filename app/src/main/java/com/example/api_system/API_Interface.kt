package com.example.api_system

import retrofit2.Call
import retrofit2.http.GET

interface API_Interface {

    @GET("/comments")
    fun getData() : Call<MutableList<Product>>
}