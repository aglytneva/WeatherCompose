package com.example.weathercompose.feature.weather_screen.data

import com.example.weathercompose.API_KEY
import com.example.weathercompose.feature.weather_screen.data.model.ModelApiHours.WeatherHourRemoteModel
import com.example.weathercompose.feature.weather_screen.data.model.ModelApiHours.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "metric",
        @Query("appid") apKey: String = "8862ccb75eb69a943650da48762ac889",
        @Query("lang") lang: String = "ru",

        ): WeatherRemoteModel


}