package com.notchdev.weathercompose.data.source.remote.dto

import com.notchdev.weathercompose.data.source.local.entity.CityEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(

    @Json(name = "country")
    val country: String?,

    @Json(name = "coord")
    val coord: Coord?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "id")
    val id: Int?
) {
    fun toCityEntity(): CityEntity {
        return CityEntity(
            cityCountry = country,
            cityCoord = coord?.toCoordEntity(),
            cityName = name,
            cityId = id
        )
    }
}