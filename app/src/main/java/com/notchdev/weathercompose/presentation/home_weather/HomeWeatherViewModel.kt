package com.notchdev.weathercompose.presentation.home_weather

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.notchdev.weathercompose.domain.usecase.GetCurrentWeatherUseCase

class HomeWeatherViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
): ViewModel(){

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state
}