package com.notchdev.weatherreporting.data.model

import com.google.gson.annotations.SerializedName
import com.notchdev.weatherreporting.data.model.City

data class NetworkWeatherForecastResponse(

    @SerializedName("list")
    val weathers: List<NetworkWeatherForecast>,

    val city: City
)
