package com.example.androiddevchallengepuppy.navigation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.androiddevchallengepuppy.components.PuppieCard
import com.example.androiddevchallengepuppy.data.Puppies

@Composable
fun Home(navController: NavController) {
    val listState = rememberLazyListState()
    Scaffold(topBar =  {
        TopAppBar(title = { Text(text = "Puppy Adoption") })
    }) {
        LazyColumn(state = listState) {
            items(Puppies.LIST) {
                PuppieCard(puppy = it, navController)
            }
        }
    }
}