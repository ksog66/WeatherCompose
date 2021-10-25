package com.notchdev.weathercompose.domain.usecase

import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import com.notchdev.weathercompose.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetWeatherForecastUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun getWeatherForecast(cityId:String): Flow<Resource<ForecastEntity>> {
        return weatherRepository.getWeatherForecast(cityId)
    }
}