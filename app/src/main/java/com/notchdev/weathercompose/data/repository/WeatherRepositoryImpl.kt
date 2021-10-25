package com.notchdev.weathercompose.data.repository

import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.local.WeatherLocalDataSource
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import com.notchdev.weathercompose.data.source.remote.WeatherRemoteDataSource
import com.notchdev.weathercompose.domain.repository.WeatherRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
): WeatherRepository {

    override fun getCurrentWeather(
        lat: Double,
        long: Double
    ): Flow<Resource<CurrentWeatherEntity>> {
        return networkBoundResource(
            query = { weatherLocalDataSource.getCurrentWeather() },
            fetch = {
                delay(100)
                weatherRemoteDataSource.getCurrentWeather(
                    lat = lat,
                    long = long
                )
            },
            saveFetchResult = { networkWeather ->
                weatherLocalDataSource.insertCurrentWeather(networkWeather.data!!.toWeatherEntity())
            }
        )
    }

    override fun getSpecificWeather(location: String): Flow<Resource<CurrentWeatherEntity>> {
        return networkBoundResource(
            query = { weatherLocalDataSource.getCurrentWeather()},
            fetch = {
                delay(100)
                weatherRemoteDataSource.getSpecificWeather(location)
            },
            saveFetchResult = { networkWeather->
                weatherLocalDataSource.insertCurrentWeather(networkWeather.data!!.toWeatherEntity())
            }
        )
    }

    override fun getWeatherForecast(cityId: String): Flow<Resource<ForecastEntity>> {
        return networkBoundResource(
            query = { weatherLocalDataSource.getWeatherForecast()},
            fetch = {
                delay(100)
                weatherRemoteDataSource.getWeatherForecast(cityId = cityId)
            },
            saveFetchResult = { weatherForecast ->
                weatherLocalDataSource.insertWeatherForecast(weatherForecast.data!!.toForecastEntity())
            }
        )
    }
}