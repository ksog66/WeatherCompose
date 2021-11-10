package com.notchdev.weathercompose.data.source.remote.network

import androidx.core.os.BuildCompat
import com.notchdev.weathercompose.data.source.remote.dto.ForecastResponse
import com.notchdev.weathercompose.data.source.remote.dto.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/205/weather")
    suspend fun getSpecificWeather(
        @Query("q") location:String,
        @Query("appid") apiKey: String
    ) : Response<WeatherResponse>

    @GET("/data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude:Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey:String
    ) : Response<WeatherResponse>

    @GET("/data/2.5/forecast")
    suspend fun getWeatherForecast(
        @Query("id") cityId:String,
        @Query("appid") apiKey: String
    ): Response<ForecastResponse>

}