package com.example.cocktail_menu

import android.app.Application
import com.example.cocktail_menu.DI.NetworkModule
import com.example.cocktail_menu.DI.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CockTailApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@CockTailApp)
            modules(listOf(NetworkModule, viewModelModule))
        }
    }
}