package com.notchdev.weathercompose.data.source.remote

import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.remote.dto.ForecastResponse
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse
import com.notchdev.weathercompose.data.source.remote.network.WeatherApi
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApi
) {

    suspend fun getCurrentWeather(): Resource<WeatherResponse> {
        TODO()
    }

    suspend fun getSpecificWeather(): Resource<WeatherResponse> {
        TODO()
    }

    suspend fun getWeatherForecast(): Resource<ForecastResponse> {
        TODO()
    }
}