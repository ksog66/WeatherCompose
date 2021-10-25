package com.notchdev.weathercompose.presentation.home_weather

import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity

data class WeatherState(
    val isLoading:Boolean = false,
    val weather:CurrentWeatherEntity?=null,
    val error:String = ""
)