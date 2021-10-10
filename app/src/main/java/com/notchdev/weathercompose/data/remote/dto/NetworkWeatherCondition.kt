package com.notchdev.weatherreporting.data.model

import java.io.Serializable

data class NetworkWeatherCondition(
    var temp: Double,
    val pressure: Double,
    val humidity: Double
) : Serializable
