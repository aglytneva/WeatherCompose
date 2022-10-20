package com.example.weathercompose.feature.weather_screen

import com.example.weathercompose.base.Either
import com.example.weathercompose.base.attempt
import com.example.weathercompose.feature.weather_screen.data.WeatherRepo
import com.example.weathercompose.feature.weather_screen.ui.model.TempModel
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherModel
import com.example.weathercompose.feature.weather_screen.ui.model.WindModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getTemp(city: String): Either<Throwable, TempModel> {
        return attempt { weatherRepo.getTemperature(city = city) }
    }

    suspend fun getWind(city: String): Either<Throwable, WindModel> {
        return attempt { weatherRepo.getWind(city = city) }
    }

    suspend fun getWeather(city: String): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getWeather(city = city) }
    }
}