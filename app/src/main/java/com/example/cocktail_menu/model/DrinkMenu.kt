package com.example.cocktail_menu.model


import com.google.gson.annotations.SerializedName

data class DrinkMenu(
    @SerializedName("drinks")
    val drinks: List<Drink?>?
)