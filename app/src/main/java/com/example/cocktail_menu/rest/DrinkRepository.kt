package com.example.cocktail_menu.rest

import com.example.cocktail_menu.model.DrinkMenu
import retrofit2.Response
import javax.inject.Inject

interface DrinkRepository {
    suspend fun getADrink(): Response<DrinkMenu>
    suspend fun getRandomDrink(): Response<DrinkMenu>

}

class DrinkRepoImplementation @Inject constructor (private val drinksAPI: DrinksAPI)
    : DrinkRepository{


    override suspend fun getADrink(): Response<DrinkMenu> = drinksAPI.getADrink()
    override suspend fun getRandomDrink(): Response<DrinkMenu> = drinksAPI.getRandomDrink()

}