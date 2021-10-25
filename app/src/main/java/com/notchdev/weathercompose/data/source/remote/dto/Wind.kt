package com.notchdev.weathercompose.data.source.remote.dto


import com.notchdev.weathercompose.data.source.local.entity.WindEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "deg")
    val deg: Double,
    @Json(name = "speed")
    val speed: Double
) {
    fun toWindEntity(): WindEntity {
        return WindEntity(
            deg = deg,
            speed = speed
        )
    }
}