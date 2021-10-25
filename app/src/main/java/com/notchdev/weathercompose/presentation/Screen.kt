package com.notchdev.weathercompose.presentation

sealed class Screen(val route:String) {
    object HomeWeatherScreen: Screen("home_weather_screen")
    object SearchCityScreen:Screen("search_city_screen")
}