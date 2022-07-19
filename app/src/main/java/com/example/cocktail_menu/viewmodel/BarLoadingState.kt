package com.example.cocktail_menu.viewmodel

import retrofit2.Response

sealed class BarLoadingState{
    object LOADING: BarLoadingState()
    class SUCCESS<T>(val response: T) : BarLoadingState()
    class ERROR(val error: Throwable) : BarLoadingState()
}
