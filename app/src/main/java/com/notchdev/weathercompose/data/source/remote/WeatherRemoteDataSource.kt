package com.notchdev.weathercompose.data.source.remote

import com.notchdev.weathercompose.common.Constants.API_KEY
import com.notchdev.weathercompose.common.DispatcherProvider
import com.notchdev.weathercompose.common.Resource
import com.notchdev.weathercompose.data.source.remote.dto.ForecastResponse
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse
import com.notchdev.weathercompose.data.source.remote.network.WeatherApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val weatherApi: WeatherApi
) {

    suspend fun getCurrentWeather(lat: Double, long: Double): Resource<WeatherResponse?> =
        withContext(dispatchers.io) {
            return@withContext try {
                val result = weatherApi.getCurrentWeather(
                    latitude = lat,
                    longitude = long,
                    apiKey = API_KEY
                )
                if (result.isSuccessful) {
                    val currentWeather = result.body()
                    Resource.Success(data = currentWeather)
                } else {
                    Resource.Success(null)
                }
            } catch (exception: Exception) {
                val errorMessage = exception.message ?: "Unexpected Error"
                Resource.Error(message = errorMessage)
            }
        }

    suspend fun getSpecificWeather(location: String): Resource<WeatherResponse?> =
        withContext(dispatchers.io) {
            return@withContext try {
                val result = weatherApi.getSpecificWeather(
                    location = location,
                    apiKey = API_KEY
                )
                if (result.isSuccessful) {
                    val specificWeather = result.body()
                    Resource.Success(specificWeather)
                } else {
                    Resource.Success(null)
                }
            } catch (exception: Exception) {
                val errorMessage = exception.localizedMessage ?: "Unexpected Error"
                Resource.Error(message = errorMessage)
            }
        }

    suspend fun getWeatherForecast(cityId: String): Resource<ForecastResponse?> =
        withContext(dispatchers.io) {
            return@withContext try {
                val result = weatherApi.getWeatherForecast(cityId = cityId, apiKey = API_KEY)
                if (result.isSuccessful) {
                    val weatherForecast = result.body()
                    Resource.Success(weatherForecast)
                } else {
                    Resource.Success(null)
                }
            } catch (exception: Exception) {
                val errorMessage = exception.localizedMessage ?: "Unexpected Error"
                Resource.Error(errorMessage)
            }
        }
}