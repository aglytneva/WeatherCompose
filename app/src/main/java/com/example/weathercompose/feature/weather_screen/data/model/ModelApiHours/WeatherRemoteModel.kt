package com.example.weathercompose.feature.weather_screen.data.model.ModelApiHours

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    val cnt: Int,
    val cod: String,
    @SerializedName("list")
    val list: List<WeatherHourRemoteModel>,
    val message: Int
)