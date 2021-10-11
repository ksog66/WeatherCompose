package com.notchdev.weathercompose.domain.usecase

import androidx.lifecycle.LiveData
import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.remote.dto.ForecastResponse
import com.notchdev.weathercompose.domain.repository.WeatherRepository

class GetWeatherForecastUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun getWeatherForecast(cityId:String): LiveData<Resource<ForecastResponse>> {
        TODO()
    }
}