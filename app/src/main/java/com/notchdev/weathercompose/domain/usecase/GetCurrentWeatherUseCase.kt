package com.notchdev.weathercompose.domain.usecase

import androidx.lifecycle.LiveData
import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse
import com.notchdev.weathercompose.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun getCurrentWeather(latitude:Double,longitude:Double): LiveData<Resource<WeatherResponse>> {
        TODO()
    }
}