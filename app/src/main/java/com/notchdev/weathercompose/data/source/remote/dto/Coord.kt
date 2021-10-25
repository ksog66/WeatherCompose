package com.notchdev.weathercompose.data.source.remote.dto


import com.notchdev.weathercompose.data.source.local.entity.CoordEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coord(
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "lon")
    val lon: Double?
) {
    fun toCoordEntity(): CoordEntity {
        return CoordEntity(
            lat = lat,
            lon = lon
        )
    }
}