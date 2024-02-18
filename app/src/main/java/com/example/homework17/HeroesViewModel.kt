package com.example.homework17

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroesViewModel(private val repository: HeroesRepository) : ViewModel() {

    private val _heroes = MutableLiveData<List<Hero>>()
    val heroes: LiveData<List<Hero>> = _heroes

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        loadHeroes()
    }

    private fun loadHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val heroesList = repository.getSuperheroes()
                _heroes.postValue(heroesList)
            } catch (e: Exception) {
                _error.postValue("Failed to fetch heroes: ${e.message}")
            }
        }
    }
}

class HeroesViewModelFactory(private val repository: HeroesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeroesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HeroesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}