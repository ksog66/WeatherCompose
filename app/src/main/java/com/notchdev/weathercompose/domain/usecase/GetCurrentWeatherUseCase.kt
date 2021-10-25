package com.notchdev.weathercompose.domain.usecase

import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse
import com.notchdev.weathercompose.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun getCurrentWeather(latitude: Double, longitude: Double): Flow<Resource<CurrentWeatherEntity>> {
        return weatherRepository.getCurrentWeather(
            lat = longitude,
            long = longitude
        )
    }
}