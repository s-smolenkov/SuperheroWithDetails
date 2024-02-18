package com.example.homework17

import retrofit2.http.GET

interface ApiInterface {
    @GET("/superhero-api/api/all.json")
    suspend fun getSuperheroes(): List<Hero>
}