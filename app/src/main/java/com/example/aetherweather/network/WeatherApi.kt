package com.example.aetherweather.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current.json")
    suspend fun getWeather(

        @Query("key")
        key: String,

        @Query("q")
        city: String

    ): WeatherResponse
}