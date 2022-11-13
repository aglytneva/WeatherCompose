package com.example.weathercompose.feature.weather_screen.ui

import com.example.weathercompose.base.Event
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel

data class ViewState(
    val descriptionCurent: String,
    val iconCurrent: String,
    val tempCurrent: String,
    val windDegCurrent: String,
    val city: String,
    var isSearchVisible: Boolean,
    val weatherHourForecastList: List<WeatherMainModel>,
    val weatherDayForecastList: List<WeatherMainModel>,
    val currentDay:String
)

sealed class UiEvent() : Event {
    object isSearchClicked : UiEvent()

}

sealed class DataEvent : Event {
    data class OnWeatherFetchSucceed(
        val weatherHourForecastList: List<WeatherMainModel>,
        val city: String
    ) :
        DataEvent()

    data class OnWeatherFetchFailed(val error: Throwable) : DataEvent()
    data class WeatherIsLoaded(val city: String) : DataEvent()
    data class WeatherDaysIsLoaded(val city: String) : DataEvent()


}