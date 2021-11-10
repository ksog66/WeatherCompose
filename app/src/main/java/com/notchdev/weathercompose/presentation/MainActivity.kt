package com.notchdev.weathercompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionsRequired
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.notchdev.weathercompose.common.utils.GpsUtil
import com.notchdev.weathercompose.presentation.home_weather.WeatherScreen
import com.notchdev.weathercompose.presentation.home_weather.components.LocationPermissionDetails
import com.notchdev.weathercompose.presentation.home_weather.components.LocationPermissionNotAvailable
import com.notchdev.weathercompose.presentation.search_city.SearchScreen
import com.notchdev.weathercompose.presentation.ui.theme.WeatherComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var isGPSEnabled = false

    @ExperimentalPermissionsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GpsUtil(this).turnGPSOn(object : GpsUtil.OnGpsListener {
            override fun gpsStatus(isGPSEnabled: Boolean) {
                this@MainActivity.isGPSEnabled = isGPSEnabled
            }
        })
        setContent {
            WeatherComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val locationPermission = rememberMultiplePermissionsState(
                        permissions = arrayListOf(
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                    )
                    PermissionsRequired(
                        multiplePermissionsState = locationPermission,
                        permissionsNotGrantedContent = {
                            LocationPermissionDetails(onContinueClick = locationPermission::launchMultiplePermissionRequest)
                        },
                        permissionsNotAvailableContent = {
                            LocationPermissionNotAvailable()
                        }

                    ) {
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
}