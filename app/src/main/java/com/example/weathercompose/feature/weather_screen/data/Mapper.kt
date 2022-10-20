package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.feature.weather_screen.data.model.WeatherRemoteModel
import com.example.weathercompose.feature.weather_screen.ui.model.TempModel
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherModel

import com.example.weathercompose.feature.weather_screen.ui.model.WindModel


fun WeatherRemoteModel.temperatureToDomain() = TempModel(
    temperature = this.main.temperature.substringBefore(".")
)

fun WeatherRemoteModel.windToDomain() = WindModel(
    windDeg = this.wind.windDeg,
    windSpeed = this.wind.speed.substringBefore(".")
)

fun WeatherRemoteModel.weatherToDomain() = WeatherModel(
    description = this.weather.map { it.description }.toString()
        .removeSurrounding("[", "]")
        .capitalize(),
    icon = this.weather.map { it.icon }.toString()
        .removeSurrounding("[", "]"),
)
