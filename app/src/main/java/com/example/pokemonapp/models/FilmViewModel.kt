package com.example.retrofitinclassdemo.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitinclassdemo.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilmViewModel : ViewModel(){
    private val _films = MutableStateFlow<List<Film>>(emptyList())
    val films: StateFlow<List<Film>> = _films

    init {
        fetchFilms()
    }

    private fun fetchFilms() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getFilms()
                _films.value = response.results
            } catch(e: Exception){
                //handle the error
            }
        }
    }
}