package com.notchdev.weathercompose.data.repository

import com.notchdev.weathercompose.data.source.local.WeatherLocalDataSource
import com.notchdev.weathercompose.data.source.remote.WeatherRemoteDataSource
import com.notchdev.weathercompose.data.source.remote.dto.ForecastResponse
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse
import com.notchdev.weathercompose.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
): WeatherRepository {

    override fun getCurrentWeather(lat: Double, long: Double): WeatherResponse {
        TODO("Not yet implemented")
    }

    override fun getSpecificWeather(location: String): WeatherResponse {
        TODO("Not yet implemented")
    }

    override fun getWeatherForecast(cityId: String): ForecastResponse {
        TODO("Not yet implemented")
    }
}