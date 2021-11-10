package com.notchdev.weathercompose.data.source.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.notchdev.weathercompose.data.source.remote.dto.WeatherItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
class WeatherConverter(
    private val moshi:Moshi
) {
    private val type = Types.newParameterizedType(List::class.java,WeatherItem::class.java)
    private val moshiAdapter = moshi.adapter<List<WeatherItem>>(type)

    @TypeConverter
    fun fromWeatherToList(list:List<WeatherItem>): String {
        return moshiAdapter.toJson(list)
    }

    @TypeConverter
    fun fromListToWeather(json:String?) :List<WeatherItem> {
        return moshiAdapter.fromJson(json).orEmpty()
    }
}