package com.lkb.ntsweatherapp.network

import com.lkb.ntsweatherapp.model.data.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    fun getWeather(
        @Query("q") latLong: String,
        @Query("units") units: String,
        @Query("appid") key: String
    ): Observable<WeatherResponse.WeatherData>
}