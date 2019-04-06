package com.lkb.ntsweatherapp.model.network

import com.lkb.ntsweatherapp.model.WeatherModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("forecast.json")
    fun getWeatherForecast(
        @Query("key") key: String,
        @Query("q") latLong: String,
        @Query("days") forecastDays: Int
    ): Observable<WeatherModel.WeatherApiResponse>

}