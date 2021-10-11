package com.notchdev.weathercompose.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListItem(

    @Json(name = "dt")
    val dt: Long?,

    @Json(name = "rain")
    val rain: Rain?,

    @Json(name = "dt_txt")
    val dtTxt: String?,

    @Json(name = "snow")
    val snow: Snow?,

    @Json(name = "weather")
    val weather: List<WeatherItem?>?,

    @Json(name = "main")
    val main: Main?,

    @Json(name = "clouds")
    val clouds: Clouds?,

    @Json(name = "sys")
    val sys: Sys?,

    @Json(name = "wind")
    val wind: Wind?
)
