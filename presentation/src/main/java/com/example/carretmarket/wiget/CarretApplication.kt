package com.example.carretmarket.wiget

import android.app.Application
import com.example.data.util.PreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CarretApplication: Application() {
    companion object {
        lateinit var prefs: PreferenceManager
    }

    override fun onCreate() {
        super.onCreate()
        prefs = PreferenceManager(applicationContext)
    }
}