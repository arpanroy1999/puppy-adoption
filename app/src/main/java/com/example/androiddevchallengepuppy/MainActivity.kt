package com.example.androiddevchallengepuppy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallengepuppy.navigation.Home
import com.example.androiddevchallengepuppy.navigation.PuppieDetails
import com.example.androiddevchallengepuppy.ui.theme.AndroidDevChallengePuppyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevChallengePuppyTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "home") {
                    composable("home") { Home(navController) }
                    composable(
                        "details/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { PuppieDetails(navController, it.arguments?.getInt("id") ?: 0) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidDevChallengePuppyTheme {
        Home(rememberNavController())
    }
}