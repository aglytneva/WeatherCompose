package com.example.weathercompose.feature.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weathercompose.base.BaseViewModel
import com.example.weathercompose.base.Event
import com.example.weathercompose.feature.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch


class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState =
        ViewState(
            descriptionCurent = "",
            iconCurrent = "",
            tempCurrent = "          --",
            windDegCurrent = "   --",
            city = "---",
            isSearchVisible = false,
            weatherHourForecastList = emptyList(),
            weatherDayForecastList = emptyList(),
            currentDay = ""
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {

            is DataEvent.WeatherIsLoaded -> {
                viewModelScope.launch {
                    interactor.getWeather(event.city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.OnWeatherFetchSucceed(
                                    weatherHourForecastList = it,
                                    city = event.city
                                )
                            )
                        }

                    )
                }
                return previousState.copy()
            }

            is DataEvent.OnWeatherFetchSucceed -> {
                val allWeatherList = event.weatherHourForecastList
                val hourList = allWeatherList.slice(0..12)
                hourList[0].time = "Сейчас"
                val dayList =allWeatherList.filter { it.time=="12:00" }

                return previousState.copy(
                    weatherHourForecastList = hourList,
                    city = event.city,
                    descriptionCurent = allWeatherList[0].description,
                    iconCurrent = allWeatherList[0].icon,
                    tempCurrent = "${
                        allWeatherList[0].temperature.toInt().toString()
                    }°C",
                    windDegCurrent =
                    "Ветер ${allWeatherList[0].windDeg} ${allWeatherList[0].windSpeed} м/с",
                    currentDay = allWeatherList[0].numberMonthDay,
                        weatherDayForecastList = dayList
                )
            }

            is UiEvent.isSearchClicked -> {
                return previousState.copy(
                    isSearchVisible = !previousState.isSearchVisible
                )
            }

            else -> return null
        }
    }
}



