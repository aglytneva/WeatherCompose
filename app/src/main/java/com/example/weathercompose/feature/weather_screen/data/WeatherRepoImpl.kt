package com.example.weathercompose.feature.weather_screen.data


import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel

class WeatherRepoImpl(
    private val weatherRemoteSource: WeatherRemoteSource
) : WeatherRepo {
    override suspend fun getAllWeather(city: String): List<WeatherMainModel> {
        return weatherRemoteSource.getWeather(city = city)
            .list
            .asSequence()
            .map { it.toDomain() }
            .toList()
    }

}