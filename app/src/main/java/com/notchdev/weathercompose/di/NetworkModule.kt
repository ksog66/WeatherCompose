package com.notchdev.weathercompose.di

import com.notchdev.weathercompose.common.Constants
import com.notchdev.weathercompose.data.repository.WeatherRepositoryImpl
import com.notchdev.weathercompose.data.source.local.WeatherLocalDataSource
import com.notchdev.weathercompose.data.source.remote.WeatherRemoteDataSource
import com.notchdev.weathercompose.data.source.remote.network.WeatherApi
import com.notchdev.weathercompose.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideWeatherRepository(
        localDataSource: WeatherLocalDataSource,
        remoteDataSource: WeatherRemoteDataSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            weatherLocalDataSource = localDataSource,
            weatherRemoteDataSource = remoteDataSource
        )
    }


    @Provides
    @Singleton
    fun provideWeatherAPI(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}