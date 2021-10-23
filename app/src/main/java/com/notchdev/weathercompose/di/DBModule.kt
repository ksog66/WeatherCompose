package com.notchdev.weathercompose.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.notchdev.weathercompose.common.Constants.WEATHER_DATABASE_NAME
import com.notchdev.weathercompose.data.source.local.WeatherDatabase
import com.notchdev.weathercompose.data.source.local.dao.CurrentWeatherDao
import com.notchdev.weathercompose.data.source.local.dao.ForecastDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideCurrentWeatherDao(db:WeatherDatabase) :CurrentWeatherDao{
        return db.currentWeatherDao()
    }

    @Singleton
    @Provides
    fun provideWeatherForecastDao(db: WeatherDatabase):ForecastDao {
        return db.forecastDao()
    }

    @Singleton
    @Provides
    fun provideWeatherDB(
        @ApplicationContext app: Context
        ):WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            WEATHER_DATABASE_NAME
        ).build()
    }
}