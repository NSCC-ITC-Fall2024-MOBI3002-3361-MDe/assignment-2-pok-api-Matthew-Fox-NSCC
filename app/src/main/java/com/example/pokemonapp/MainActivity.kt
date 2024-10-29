package com.example.pokemonapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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

                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(it),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {

                                var newItem = ""

                                TextField(
                                    value = newItem,
                                    onValueChange = { newItem = it },
                                    singleLine = true,
                                    label = { Text("Search for Pokemon") },
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .background(Color.Transparent)
                                )

                                IconButton(
                                    modifier = Modifier
                                        .padding(8.dp),
                                    onClick = {
//                                    viewModel.addItem(newItem)
                                        newItem = ""
                                    }) {
//                                    Text("Add Item")
                                    Icon(Icons.Filled.Search, contentDescription = "Pokemon search button")
                                }

                            }

                            val imagePath = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
                            AsyncImage(
                                model = imagePath,
                                contentDescription = "Dynamically loaded image",
                                modifier = Modifier
                                    .size(150.dp)
                                    .padding(8.dp)
//                                    .border(1.dp, Color.Black)
//                                    .background(Color.hsl(194.7f, 0.533f, 0.79f))  // Light blue
                                    .fillMaxWidth()
//                                .clickable {
//                                    // Checks if the user clicked cat or dog and resets the CAPTCHA state.
//                                    finalTextModel.updateFinalText(onImageClick(imagePath))
//                                    imagePaths.clear()
//                                    fillList(imagePaths)
//                                }
                            )


                        }

                    }
                }
            )

        }
    }
}