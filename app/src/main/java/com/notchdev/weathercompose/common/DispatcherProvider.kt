package com.notchdev.weathercompose.common

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io:CoroutineDispatcher
    val default: CoroutineDispatcher
}