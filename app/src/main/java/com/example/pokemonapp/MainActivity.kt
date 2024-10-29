package com.example.pokemonapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.pokemonapp.components.FilmListScreen
import com.example.pokemonapp.models.FilmViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val filmViewModel = FilmViewModel()

            val films by filmViewModel.films.collectAsState()
            /*
            *   The innerPadding parameter from the Scaffold is passed to the
            *   LazyColumn’s contentPadding. This ensures that the LazyColumn
            *   respects the padding provided by the Scaffold, preventing the
            *   first item from being covered by the TopAppBar
            * */
            Scaffold(
                topBar = {
                    TopAppBar(
                        {
                            Image(
                                imageVector = ImageVector.vectorResource(R.drawable.pokemon),
                                contentDescription = "Pokemon Logo image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(60.dp)
                            )
                        }
                    )
                },
                content = { it ->
                    Scaffold (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues = it)
                    ) {

                        var newItem = ""

                        TextField(
                            value = newItem,
                            onValueChange = { newItem = it },
                            singleLine = true,
                            label = { Text("Search for Pokemon") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                    }
                }
            )

        }
    }
}