package com.example.cocktail_menu.rest


import com.example.cocktail_menu.model.DrinkMenu
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksAPI {

    @GET(PATH_URL)
    suspend fun getADrink(
//        @Query("hasimage") hasimage:String = "1",
//        @Query("apikey") apikey:String = API_KEY
    ): Response<DrinkMenu>

    @GET(RANDOM_DRINK)
    suspend fun getRandomDrink(
//        @Query("hasimage") hasimage:String = "1",
//        @Query("apikey") apikey:String = API_KEY
    ): Response<DrinkMenu>


    companion object{
        const val API_KEY = "1"
        const val BASE_URL = "http://www.thecocktaildb.com/api/json/v1/1/"
        const val PATH_URL = "search.php?f=a"
        const val RANDOM_DRINK = "random.php"

        //List all cocktails by first letter
        //www.thecocktaildb.com/api/json/v1/1/search.php?f=a
    }

}


//they look for the drink by searching the id, and then use it to get the ingredients