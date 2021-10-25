package com.notchdev.weathercompose.domain.usecase

import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetSpecificWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun getSpecificWeather(location:String): Flow<Resource<CurrentWeatherEntity>> {
        return weatherRepository.getSpecificWeather(location)
    }
}