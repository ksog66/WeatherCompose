package com.notchdev.weathercompose.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.notchdev.weathercompose.common.DataConverter
import com.notchdev.weathercompose.data.source.local.dao.CurrentWeatherDao
import com.notchdev.weathercompose.data.source.local.dao.ForecastDao
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity

@Database(
    entities = [
        ForecastEntity::class,
        CurrentWeatherEntity::class
    ],
    version = 1
)
@TypeConverters(DataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    abstract fun currentWeatherDao(): CurrentWeatherDao
}