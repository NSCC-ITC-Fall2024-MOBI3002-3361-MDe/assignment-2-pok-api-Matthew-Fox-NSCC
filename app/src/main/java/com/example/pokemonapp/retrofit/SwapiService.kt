package com.example.retrofitinclassdemo.retrofit

import com.example.retrofitinclassdemo.models.FilmResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SwapiService {
    @GET("films")
    suspend fun getFilms(): FilmResponse
}

object RetrofitInstance {
    val api: SwapiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SwapiService::class.java)
    }
}