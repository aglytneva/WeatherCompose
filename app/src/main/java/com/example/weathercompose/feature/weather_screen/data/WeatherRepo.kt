package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.feature.weather_screen.ui.model.TempModel
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherModel


import com.example.weathercompose.feature.weather_screen.ui.model.WindModel


interface WeatherRepo {
    suspend fun getTemperature(city: String): TempModel
    suspend fun getWind(city: String): WindModel
    suspend fun getWeather(city: String): WeatherModel
}