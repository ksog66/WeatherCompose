package com.notchdev.weathercompose.presentation.home_weather

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionsRequired
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@ExperimentalPermissionsApi
@Composable
fun WeatherScreen(
    viewModel: HomeWeatherViewModel = hiltViewModel()
) {
    val location by viewModel.getLocationLiveData().observeAsState()
    location?.let {
        viewModel.getCurrentWeather(it.lat,it.long)
    }
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.weather?.let { weather ->
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Face,
                    contentDescription = "WeatherStatus"
                )
                Text(
                    text = "Friday, Nov 5"
                )
                Text(
                    text = "Sunny day"
                )

                Text(
                    text = "20C"
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@ExperimentalPermissionsApi
private fun requestPermission() {

}
