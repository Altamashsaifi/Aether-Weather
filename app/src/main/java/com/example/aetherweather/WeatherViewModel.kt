package com.example.aetherweather

import androidx.compose.runtime.*

import androidx.lifecycle.ViewModel
import com.example.aetherweather.R


import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    var weatherIcon by mutableStateOf(
        R.drawable.ic_sun
    )

    var updatedAt by mutableStateOf(
        "--:--"
    )

    var city by mutableStateOf(
        "New Delhi"
    )

    var temperature by mutableStateOf(
        "--"
    )

    var condition by mutableStateOf(
        "Loading..."
    )

    fun loadWeather() {

        viewModelScope.launch {

            try {

                val data =

                    WeatherRepository
                        .getWeather(
                            "$city, India"
                        )

                city =
                    data.location.name

                temperature =
                    "${data.current.temp_c}°"

                condition =
                    "${data.current.condition.text} | ${data.current.humidity}%"

                updatedAt =
                    data.current.last_updated

                weatherIcon = when {

                    condition.contains(
                        "sun",
                        true
                    ) ->
                        R.drawable.ic_sun

                    condition.contains(
                        "cloud",
                        true
                    ) ->
                        R.drawable.ic_cloud

                    condition.contains(
                        "rain",
                        true
                    ) ->
                        R.drawable.ic_rain

                    condition.contains(
                        "fog",
                        true
                    ) ->
                        R.drawable.ic_fog

                    condition.contains(
                        "storm",
                        true
                    ) ->
                        R.drawable.ic_storm

                    condition.contains(
                        "night",
                        true
                    ) ->
                        R.drawable.ic_moon

                    else ->
                        R.drawable.ic_sun

                }

            }

            catch (
                e: Exception
            ) {

                condition =
                    "Failed to load"

            }

        }

    }

}