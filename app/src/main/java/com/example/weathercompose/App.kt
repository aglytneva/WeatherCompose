package com.example.weathercompose

import android.app.Application
import com.example.weathercompose.feature.weather_screen.di.weatherScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(weatherScreenModule)
        }


    }
}