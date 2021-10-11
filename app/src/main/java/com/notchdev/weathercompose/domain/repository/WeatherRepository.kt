package com.notchdev.weathercompose.domain.repository

import com.notchdev.weathercompose.data.source.remote.dto.ForecastResponse
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse

interface WeatherRepository {

    fun getCurrentWeather(lat:Double,long:Double): WeatherResponse

    fun getSpecificWeather(location:String): WeatherResponse

    fun getWeatherForecast(cityId:String): ForecastResponse
}