package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.feature.weather_screen.data.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {
    //TO DO add query
    suspend fun getWeather(city: String): WeatherRemoteModel {
        return api.getWeather(query = city)
    }
}