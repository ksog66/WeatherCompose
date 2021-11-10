package com.notchdev.weathercompose.presentation.home_weather

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.common.utils.LocationLiveData
import com.notchdev.weathercompose.domain.usecase.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeWeatherViewModel @Inject constructor(
    application:Application,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
): ViewModel() {

    private val locationLiveData = LocationLiveData(application)

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    fun getLocationLiveData() = locationLiveData

    fun getCurrentWeather(lat: Double, long: Double) {
        getCurrentWeatherUseCase.getCurrentWeather(latitude = lat, longitude = long)
            .onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = WeatherState(error = result.error ?: "Something went wrong")
                    }
                    is Resource.Loading -> {
                        _state.value = WeatherState(isLoading = true)
                    }
                    is Resource.Success -> {
                        _state.value = WeatherState(weather = result.data)
                    }
                }
            }.launchIn(viewModelScope)
    }
}