package com.example.weathercompose.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherWeatherRemoteModel(

    @SerializedName("description")
    val description: String,

    @SerializedName("icon")
    val icon: String,


    )