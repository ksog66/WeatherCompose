package com.notchdev.weathercompose.data.source.remote.dto

import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastResponse(

    @Json(name = "city")
    val city: City?,

    @Json(name = "cnt")
    val cnt: Int?,

    @Json(name = "cod")
    val cod: String?,

    @Json(name = "message")
    val message: Double?,

    @Json(name = "list")
    val list: List<ListItem>?
) {
    fun toForecastEntity(): ForecastEntity {
        return ForecastEntity(
            city = city?.toCityEntity(),
            list = list
        )
    }
}