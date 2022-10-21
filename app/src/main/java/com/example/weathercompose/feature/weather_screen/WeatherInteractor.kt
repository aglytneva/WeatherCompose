package com.example.weathercompose.feature.weather_screen

import com.example.weathercompose.base.Either
import com.example.weathercompose.base.attempt
import com.example.weathercompose.feature.weather_screen.data.WeatherRepo
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(city: String): Either<Throwable, List<WeatherMainModel>> {
        return attempt { weatherRepo.getAllWeather(city = city) }
    }

}