package com.example.weathercompose.feature.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weathercompose.base.BaseViewModel
import com.example.weathercompose.base.Event
import com.example.weathercompose.feature.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch


class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState =
        ViewState(
            description = "",
            iconWeather = "",
            temperature = "          --",
            windDeg = "   --",
            city = "---",
            isSearchVisible = false
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.TempIsLoaded -> {
                viewModelScope.launch {
                    interactor.getTemp(event.city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.OnTempFetchSucceed(
                                    temperature = it.temperature,
                                    city = event.city
                                )
                            )
                        }

                    )
                }

            }
            is DataEvent.WeatherIsLoaded -> {
                viewModelScope.launch {
                    interactor.getWeather(event.city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.OnWeatherFetchSucceed(
                                    weatherModel = it,
                                    city = event.city
                                )
                            )
                        }

                    )
                }

                return previousState.copy()
            }
            is DataEvent.WindIsLoaded -> {
                viewModelScope.launch {
                    interactor.getWind(event.city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.OnWindFetchSucceed(
                                    windDeg = "  Ветер ${it.toTextualDescription(windDeg = it.windDeg)}" +
                                            "  ${it.windSpeed} м/с",
                                    city = event.city
                                )
                            )
                        }
                    )
                }
            }
            is DataEvent.OnTempFetchSucceed -> {
                return previousState.copy(
//                    isLoadingTemp = false,
                    temperature = event.temperature,
                    city = event.city
                )
            }
            is DataEvent.OnWindFetchSucceed -> {
                return previousState.copy(
//                    isLoadingWind = false,
                    windDeg = event.windDeg,
                    city = event.city
                )
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(
//                    isLoadingWind = false,
                    description = event.weatherModel.description,
                    iconWeather = event.weatherModel.icon,
                    city = event.city
                )
            }
            is UiEvent.isSearchClicked -> {
                return previousState.copy(
                    isSearchVisible = !previousState.isSearchVisible
                )
            }



            else -> return null
        }
        return null
    }
}



