package com.notchdev.weathercompose.presentation.home_weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notchdev.weathercompose.R
import com.notchdev.weathercompose.presentation.ui.theme.RainyGrey
import com.notchdev.weathercompose.presentation.ui.theme.SunnyGreen

@Composable
fun LocationPermissionDetails(onContinueClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(SunnyGreen)
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = rememberVectorPainter(image = Icons.Filled.LocationOn),
            contentDescription = stringResource(id = R.string.location_permission_content_description),
            modifier = Modifier.size(68.dp)
        )
        Text(
            text = stringResource(R.string.location_permission_description),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.White
        )
        Button(onClick = onContinueClick) {
            Text(
                text = stringResource(R.string.location_permission_continue)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun LocationPermissionNotAvailable() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(RainyGrey)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = rememberVectorPainter(image = Icons.Filled.LocationOn),
            contentDescription = stringResource(R.string.location_permission_content_description),
            modifier = Modifier.size(68.dp)
        )
        Text(
            text = stringResource(R.string.location_permission_not_available),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}