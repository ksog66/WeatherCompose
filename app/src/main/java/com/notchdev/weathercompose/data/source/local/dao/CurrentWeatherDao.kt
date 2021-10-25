package com.notchdev.weathercompose.data.source.local.dao

import androidx.room.*
import com.notchdev.weathercompose.data.source.local.entity.CurrentWeatherEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentWeather(currentWeather: CurrentWeatherEntity)

    @Transaction
    suspend fun deleteAndInsert(currentWeatherEntity: CurrentWeatherEntity) {
        deleteAllWeather()
        insertCurrentWeather(currentWeatherEntity)
    }
    @Query("SELECT* FROM currentweather ORDER BY unique_id DESC LIMIT 1")
    fun getCurrentWeather(): Flow<CurrentWeatherEntity>

    @Query("DELETE FROM currentWeather")
    suspend fun deleteAllWeather()
}