package com.example.weathercompose.feature.weather_screen.ui

import com.example.weathercompose.base.Event
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherModel

data class ViewState(
    val description: String,
    val iconWeather: String,
    val temperature: String,
    val windDeg: String,
    val city: String,
    var isSearchVisible:Boolean
)

sealed class UiEvent() : Event {
    object isSearchClicked :UiEvent()


}

sealed class DataEvent : Event {
    data class OnTempFetchSucceed(val temperature: String, val city: String) : DataEvent()
    data class OnWindFetchSucceed(val windDeg: String, val city: String) : DataEvent()
    data class OnWeatherFetchSucceed(val weatherModel: WeatherModel, val city: String) : DataEvent()
    data class OnWeatherFetchFailed(val error: Throwable) : DataEvent()
    data class TempIsLoaded(val city: String) : DataEvent()
    data class WindIsLoaded(val city: String) : DataEvent()
    data class WeatherIsLoaded(val city: String) : DataEvent()
}