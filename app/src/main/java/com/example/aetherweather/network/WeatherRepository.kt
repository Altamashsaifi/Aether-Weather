package com.example.aetherweather

import com.example.aetherweather.network.WeatherApi
import com.example.aetherweather.network.WeatherResponse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherRepository {

    private val api =

        Retrofit.Builder()

            .baseUrl(
                "https://api.weatherapi.com/v1/"
            )

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()

            .create(
                WeatherApi::class.java
            )

    suspend fun getWeather(
        city: String
    ): WeatherResponse {

        return api.getWeather(
            ApiKey.KEY,
            city
        )

    }

}