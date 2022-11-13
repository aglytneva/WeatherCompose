package com.example.weathercompose.feature.weather_screen.di

import com.example.weathercompose.BASE_URL
import com.example.weathercompose.feature.weather_screen.WeatherInteractor
import com.example.weathercompose.feature.weather_screen.data.*
import com.example.weathercompose.feature.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {
    /*
    presenter = WetherScreenPresenter(
        WeatherInteractor(
            WeatherRepoImpl(
                WeatherRemoteSource(
                    WeatherApiClient.getApi()
                )
            )
        )
    )
    */

    // создаем okHttpClient
    single<OkHttpClient> { OkHttpClient.Builder().build() }

    //создаем сам ретрофит
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherApi> { get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get<WeatherApi>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single { WeatherInteractor(get<WeatherRepo>()) }

    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }
}