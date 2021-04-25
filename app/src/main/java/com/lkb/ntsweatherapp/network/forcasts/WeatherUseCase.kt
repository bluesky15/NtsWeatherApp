package com.lkb.ntsweatherapp.network.forcasts

import com.lkb.ntsweatherapp.network.WeatherApiService
import com.lkb.ntsweatherapp.model.data.WeatherResponse
import io.reactivex.Observable

class WeatherUseCase(weatherApiService: WeatherApiService) {
    private val mWeatherApiService = weatherApiService

    fun fetchWeather(place: String, units: String, key:String): Observable<WeatherResponse.WeatherData> {
        return mWeatherApiService.getWeather(place,units,key)
    }


}