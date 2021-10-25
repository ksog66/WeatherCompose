package com.notchdev.weathercompose.data.source.remote.dto


import com.notchdev.weathercompose.data.source.local.entity.CloudsEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Clouds(
    @Json(name = "all")
    val all: Int?
) {
    fun toCloudEntity(): CloudsEntity {
        return CloudsEntity(
            all = all
        )
    }
}