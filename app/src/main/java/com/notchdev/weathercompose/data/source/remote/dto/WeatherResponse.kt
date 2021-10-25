package com.notchdev.weathercompose.data.source.remote.dto


import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name = "base")
    val base: String,
    @Json(name = "clouds")
    val clouds: Clouds,
    @Json(name = "cod")
    val cod: Int,
    @Json(name = "coord")
    val coord: Coord,
    @Json(name = "dt")
    val dt: Long,
    @Json(name = "id")
    val id: Int,
    @Json(name = "main")
    val main: Main,
    @Json(name = "name")
    val name: String,
    @Json(name = "sys")
    val sys: Sys,
    @Json(name = "timezone")
    val timezone: Int,
    @Json(name = "visibility")
    val visibility: Int,
    @Json(name = "weather")
    val weather: List<WeatherItem>,
    @Json(name = "wind")
    val wind: Wind
) {

    fun toWeatherEntity(): CurrentWeatherEntity {
        return CurrentWeatherEntity(
            visibility = visibility,
            timezone = timezone,
            main = main.toMainEntity(),
            clouds = clouds.toCloudEntity(),
            dt = dt,
            weather = weather,
            name = name,
            base = base,
            wind = wind.toWindEntity()
        )
    }
}