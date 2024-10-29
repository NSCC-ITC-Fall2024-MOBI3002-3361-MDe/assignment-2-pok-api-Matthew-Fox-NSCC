package com.example.retrofitinclassdemo.models

data class Film(
    val title: String,
    val episode_id: Int,
    val release_date: String
)

data class FilmResponse(
    val results: List<Film>
)

