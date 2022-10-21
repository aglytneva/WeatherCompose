package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.feature.weather_screen.data.model.ModelApi.WeatherRemoteModel
import com.example.weathercompose.feature.weather_screen.data.model.ModelApi.WeatherDayRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {
    //TO DO add query
    suspend fun getWeather(city: String): WeatherRemoteModel {
        return api.getWeather(query = city)
    }
}
