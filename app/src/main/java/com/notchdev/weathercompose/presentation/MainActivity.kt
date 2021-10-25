package com.notchdev.weathercompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.notchdev.weathercompose.presentation.home_weather.WeatherScreen
import com.notchdev.weathercompose.presentation.search_city.SearchScreen
import com.notchdev.weathercompose.presentation.ui.theme.WeatherComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController,
                        startDestination = Screen.HomeWeatherScreen.route
                    ) {
                        composable(
                            route = Screen.HomeWeatherScreen.route
                        ) {
                            WeatherScreen()
                        }

                        composable(
                            route = Screen.SearchCityScreen.route
                        ) {
                            SearchScreen()
                        }
                    }
                }
            }
        }
    }
}