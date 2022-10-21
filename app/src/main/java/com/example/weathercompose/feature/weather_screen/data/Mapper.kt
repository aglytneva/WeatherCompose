package com.example.weathercompose.feature.weather_screen.data

import androidx.compose.ui.text.capitalize
import com.example.weathercompose.feature.weather_screen.data.model.ModelApi.WeatherDayRemoteModel
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel

fun WeatherDayRemoteModel.toDomain() = WeatherMainModel(
    temperature = main.temp,
    description = weather
        .map { it.description }
        .toString()
        .removeSurrounding("[", "]")
        .capitalize(),
    icon = weather
        .map { it.icon }
        .toString()
        .removeSurrounding("[", "]"),
    windDeg = dt_txt,
    windSpeed = dt_txt,
    allDateWeather = dt_txt,

    )
