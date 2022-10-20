package com.example.weathercompose.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("weather")
    val weather: List<WeatherWeatherRemoteModel>,

    @SerializedName("main")
    val main: WeatherMainRemoteModel,

    @SerializedName("wind")
    val wind: WeatherWindRemoteModel,


    )
