package com.example.weathercompose.feature.weather_screen.data.model.ModelApiHours

import com.google.gson.annotations.SerializedName

data class WeatherHourRemoteModel(
    val dt: Int,
    @SerializedName("dt_txt")
    val dt_txt: String,
    @SerializedName("main")
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    val wind: Wind
)
