package com.example.cocktail_menu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktail_menu.model.Drink
import com.example.cocktail_menu.rest.DrinkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrinkViewModel (
    private val drinkRepo: DrinkRepository
): ViewModel() {
    private val _drinkerLiveData: MutableLiveData<BarLoadingState> =
        MutableLiveData(BarLoadingState.LOADING)
    val drinkerLiveData:LiveData<BarLoadingState> get() = _drinkerLiveData
    var fragmentDetail:MutableLiveData<Drink> = MutableLiveData()

    fun getDrinker() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = drinkRepo.getADrink()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _drinkerLiveData.postValue(BarLoadingState.SUCCESS(it))
                    } ?: throw Exception("Response was null")
                } else {
                    throw Exception("Response was unsuccessful")
                }
            } catch (e: Exception) {
                _drinkerLiveData.postValue(BarLoadingState.ERROR(e))
            }

        }
    }

        fun getFragmentDetail(record:Drink){
            fragmentDetail = MutableLiveData(record)
        }
}

