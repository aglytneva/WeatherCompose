package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.feature.weather_screen.ui.model.TempModel
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherModel


import com.example.weathercompose.feature.weather_screen.ui.model.WindModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(city: String): TempModel {
        return weatherRemoteSource.getWeather(city = city).temperatureToDomain()
    }

    override suspend fun getWind(city: String): WindModel {
        return weatherRemoteSource.getWeather(city = city).windToDomain()
    }

    override suspend fun getWeather(city: String): WeatherModel {
        return weatherRemoteSource.getWeather(city = city).weatherToDomain()
    }

}