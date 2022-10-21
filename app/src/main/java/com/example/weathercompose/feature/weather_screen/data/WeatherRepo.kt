package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel


interface WeatherRepo {
    suspend fun getAllWeather(city: String):List<WeatherMainModel>

}