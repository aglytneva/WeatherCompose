package com.example.weathercompose.feature.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weathercompose.base.BaseViewModel
import com.example.weathercompose.base.Event
import com.example.weathercompose.feature.weather_screen.WeatherInteractor
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel
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
            weatherDayForecastList = emptyList()
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
                return previousState.copy(
                    weatherHourForecastList = event.weatherHourForecastList.slice(0..12),
                    city = event.city,
                    descriptionCurent = event.weatherHourForecastList[0].description,
                    iconCurrent = event.weatherHourForecastList[0].icon,
                    tempCurrent = "${
                        event.weatherHourForecastList[0].temperature.toInt().toString()
                    }°C",
                    windDegCurrent = event.weatherHourForecastList[0].windDeg,
                    weatherDayForecastList =
                        event.weatherHourForecastList
                            .slice(0..event.weatherHourForecastList.size step 12)
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



