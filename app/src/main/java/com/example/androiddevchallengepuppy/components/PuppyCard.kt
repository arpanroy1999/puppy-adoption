package com.example.androiddevchallengepuppy.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallengepuppy.data.Puppies
import com.example.androiddevchallengepuppy.model.Puppy

@Composable
fun PuppieCard(puppy: Puppy, navController: NavController) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(), elevation = 4.dp) {
        Column {
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                NetworkImage(puppy.thumbnail, "${puppy.name}'s Image", modifier = Modifier
                    .width(100.dp)
                    .height(100.dp).padding(8.dp))
                Column(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)) {
                    Text(modifier = Modifier.padding(bottom = 8.dp, top = 8.dp), text = puppy.name, style = MaterialTheme.typography.h5)
                    Text(text = puppy.aboutInfo.substring(0, 120) + "...", style = MaterialTheme.typography.caption)
                }
            }
            Divider()
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.End) {
                TextButton(onClick = { navController.navigate("details/${Puppies.LIST.indexOf(puppy)}") }) {
                    Text(text = "LEARN MORE")
                }
            }
        }
       
    }
}