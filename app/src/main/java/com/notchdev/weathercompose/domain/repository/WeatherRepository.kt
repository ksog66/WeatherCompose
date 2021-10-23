package com.notchdev.weathercompose.domain.repository

import androidx.lifecycle.LiveData
import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import com.notchdev.weathercompose.data.source.remote.dto.ForecastResponse
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse

interface WeatherRepository {

    fun getCurrentWeather(lat:Double,long:Double): LiveData<Resource<CurrentWeatherEntity>>

    fun getSpecificWeather(location:String): LiveData<Resource<CurrentWeatherEntity>>

    fun getWeatherForecast(cityId:String): LiveData<Resource<ForecastEntity>>
}