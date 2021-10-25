package com.notchdev.weathercompose.domain.repository

import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getCurrentWeather(lat:Double,long:Double): Flow<Resource<CurrentWeatherEntity>>

    fun getSpecificWeather(location:String): Flow<Resource<CurrentWeatherEntity>>

    fun getWeatherForecast(cityId:String): Flow<Resource<ForecastEntity>>
}