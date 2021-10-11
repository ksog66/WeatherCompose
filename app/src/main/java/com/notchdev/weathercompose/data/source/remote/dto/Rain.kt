package com.notchdev.weathercompose.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rain(

    @Json(name = "3h")
    val jsonMember3h: Double?
)