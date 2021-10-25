package com.notchdev.weathercompose.data.source.local.dao

import androidx.room.*
import com.notchdev.weathercompose.data.source.local.entity.ForecastEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(forecastWeather: ForecastEntity)

    @Query("SELECT * FROM forecast ORDER BY id DESC LIMIT 1")
    fun getAllWeatherForecast(): Flow<ForecastEntity>

    @Transaction
    suspend fun deleteAndInsertForecast(forecastEntity: ForecastEntity) {
        deleteAllWeatherForecast()
        insertForecast(forecastEntity)
    }

    @Query("DELETE FROM forecast")
    suspend fun deleteAllWeatherForecast()
}