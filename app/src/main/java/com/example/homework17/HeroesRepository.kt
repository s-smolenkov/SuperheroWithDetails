package com.example.homework17

class HeroesRepository(private val api: ApiInterface) {

    suspend fun getSuperheroes(): List<Hero> {
        return api.getSuperheroes()
    }
}