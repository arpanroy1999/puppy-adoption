package com.example.androiddevchallengepuppy.navigation

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androiddevchallengepuppy.components.NetworkImage
import com.example.androiddevchallengepuppy.data.Puppies.LIST

@Composable
fun PuppieDetails(navController: NavController, id: Int) {
    val puppie = LIST[id]
    val scroll = rememberLazyListState()
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, "Back")
            }
        }, title = { Text(text = LIST[id].name) })
    }) {
        LazyColumn(
            state = scroll,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            item {
                Card {
                    Column(Modifier.fillMaxWidth()) {
                        NetworkImage(
                            uri = puppie.image,
                            contentDescription = "${puppie.name}'s Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Box(modifier = Modifier.height(8.dp))
                            Text(text = puppie.name, style = MaterialTheme.typography.h5)
                            Box(modifier = Modifier.height(8.dp))
                            Text(text = puppie.aboutInfo, lineHeight = 24.sp, style = MaterialTheme.typography.body2)
                            Box(modifier = Modifier.height(16.dp))
                            if (puppie.moreInfoLink != null) Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                OutlinedButton(onClick = {
                                    Toast.makeText(context, "Successful", Toast.LENGTH_LONG).show()
                                }) {
                                    Text(text = "ADOPT THIS PUPPIE")
                                }
                                TextButton(onClick = {
                                    context.startActivity(Intent(Intent.ACTION_VIEW).apply {
                                        data = Uri.parse(puppie.moreInfoLink)
                                    })
                                }) {
                                    Text(text = "LEARN MORE")
                                    Box(modifier = Modifier.width(8.dp))
                                    Icon(Icons.Outlined.Info, contentDescription = "Learn More")
                                }
                            }
                        }
                    }
                }
                Box(modifier = Modifier.height(16.dp))
                Text(text = "More Images", style = MaterialTheme.typography.h5)
                Box(modifier = Modifier.height(16.dp))
            }
            itemsIndexed(puppie.images) { index, s ->
                Card(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)) {
                    NetworkImage(uri = s, contentDescription = "More image of ${puppie.name}")
                }
                if(index != puppie.images.size - 1){
                    Box(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}