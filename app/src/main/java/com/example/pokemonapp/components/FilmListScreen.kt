package com.example.retrofitinclassdemo.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofitinclassdemo.models.Film
import com.example.retrofitinclassdemo.models.FilmViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmListScreen(filmViewModel: FilmViewModel = viewModel()){

    val films by filmViewModel.films.collectAsState()
/*
*   The innerPadding parameter from the Scaffold is passed to the
*   LazyColumn’s contentPadding. This ensures that the LazyColumn
*   respects the padding provided by the Scaffold, preventing the
*   first item from being covered by the TopAppBar
* */
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Star Wars Films") })
        }
    ) { innerPadding ->
        // innerPadding is a PaddingValues object that contains the padding values needed to ensure the content is not overlapped by the TopAppBar.
        //It is automatically calculated by the Scaffold based on the height of the TopAppBar and any other components that might affect the layout.
        LazyColumn(
            contentPadding = innerPadding, //Apply the padding provided by Scaffold
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(films){ film ->
                FilmItem(film)
            }
        }
    }
}

@Composable
fun FilmItem(film: Film){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(modifier = Modifier.padding(26.dp)) {
            Text(text = "Title: ${film.title}")
            Text(text = "Episode: ${film.episode_id}")
            Text(text = "Release Date: ${film.release_date}")
        }
    }
}