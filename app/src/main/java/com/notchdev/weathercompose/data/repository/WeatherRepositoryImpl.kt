package com.notchdev.weathercompose.data.repository

import androidx.lifecycle.LiveData
import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.local.WeatherLocalDataSource
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import com.notchdev.weathercompose.data.source.remote.WeatherRemoteDataSource
import com.notchdev.weathercompose.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
): WeatherRepository {

    override fun getCurrentWeather(lat: Double, long: Double): LiveData<Resource<CurrentWeatherEntity>> {
        TODO("Not yet implemented")
    }

    override fun getSpecificWeather(location: String): LiveData<Resource<CurrentWeatherEntity>> {
        TODO("Not yet implemented")
    }

    override fun getWeatherForecast(cityId: String): LiveData<Resource<ForecastEntity>> {
        TODO("Not yet implemented")
    }
}