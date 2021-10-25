package com.notchdev.weathercompose.data.source.remote.dto


import com.notchdev.weathercompose.data.source.local.entity.MainEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "pressure")
    val pressure: Double,
    @Json(name = "temp")
    val temp: Double,
    @Json(name = "temp_max")
    val tempMax: Double,
    @Json(name = "temp_min")
    val tempMin: Double
) {
    fun toMainEntity(): MainEntity {
        return MainEntity(
            temp = temp,
            tempMin = tempMin,
            tempMax = tempMax,
            pressure = pressure,
            humidity = humidity,
            grndLevel = null,
            tempKf = null,
            seaLevel = null
        )
    }
}