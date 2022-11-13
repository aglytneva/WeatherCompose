package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.feature.weather_screen.data.model.ModelApiHours.WeatherRemoteModel

class WeatherRemoteSource(private val apiHour: WeatherApi) {
    //TO DO add query
    suspend fun getWeather(city: String): WeatherRemoteModel {
        return apiHour.getWeather(query = city)
    }

}
