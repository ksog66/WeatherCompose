package com.notchdev.weathercompose.data.source.local

import com.notchdev.weathercompose.data.source.local.dao.CurrentWeatherDao
import com.notchdev.weathercompose.data.source.local.dao.ForecastDao
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import javax.inject.Inject

class WeatherLocalDataSource @Inject constructor(
    private val currentWeatherDao: CurrentWeatherDao,
    private val forecastDao: ForecastDao
) {
    suspend fun getCurrentWeather() = currentWeatherDao.getCurrentWeather()

    suspend fun getAllCurrentWeather() = currentWeatherDao.getAllCurrentWeather()

    suspend fun insertCurrentWeather(weatherEntity: CurrentWeatherEntity) =
        currentWeatherDao.deleteAndInsert(weatherEntity)

    suspend fun getWeatherForecast() = forecastDao.getAllWeatherForecast()

    suspend fun insertWeatherForecast(forecastEntity: ForecastEntity) =
        forecastDao.deleteAndInsertForecast(
            forecastEntity = forecastEntity
        )
}