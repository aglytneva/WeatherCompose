package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.API_KEY
import com.example.weathercompose.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "metric",
        @Query("appid") apKey: String = API_KEY,
        @Query("lang") lang: String = "ru",

        ): WeatherRemoteModel
}