package com.example.homework17

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val client = Retrofit.Builder()
        .baseUrl("https://akabab.github.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ApiInterface = client.create(ApiInterface::class.java)
}