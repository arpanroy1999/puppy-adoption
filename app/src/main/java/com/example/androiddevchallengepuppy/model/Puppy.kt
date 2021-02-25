package com.example.androiddevchallengepuppy.model

data class Puppy(
   val name: String,
   val thumbnail: String,
   val image: String,
   val aboutInfo: String,
   val images: List<String> = listOf(),
   val moreInfoLink: String? = null
)