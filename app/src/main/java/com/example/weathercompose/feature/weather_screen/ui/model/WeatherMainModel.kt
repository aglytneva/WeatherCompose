package com.example.weathercompose.feature.weather_screen.ui.model

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class WeatherMainModel(
    val description: String,
    val icon: String,
    val temperature: Double,
    val maxTemperature: Double,
    val minTemperature: Double,
    val windDeg: String,
    val windSpeed: String,
    val allDateWeather: String,
    val weekDay: String,
    val numberMonthDay: String,
    var time: String,
    val rainProbability:String
)



