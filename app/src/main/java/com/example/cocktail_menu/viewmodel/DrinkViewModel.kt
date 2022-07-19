package com.example.cocktail_menu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktail_menu.rest.DrinkRepository

class DrinkViewModel (
    private val drinkRepo: DrinkRepository
): ViewModel() {
    private val _drinkerLiveData: MutableLiveData<BarLoadingState> =
    MutableLiveData(BarLoadingState.LOADING)
    val drinkerLiveData:LiveData<BarLoadingState> get() = _drinkerLiveData
    // var fragmentDetail:MutableLiveData<Ingredients> = MutableLiveData()



    fun
}

