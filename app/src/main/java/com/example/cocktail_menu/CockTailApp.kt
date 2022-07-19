package com.example.cocktail_menu

import android.app.Application

class CockTailApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext
        }
    }
}