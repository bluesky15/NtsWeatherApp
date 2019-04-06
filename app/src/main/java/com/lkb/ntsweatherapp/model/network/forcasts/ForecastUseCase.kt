package com.lkb.ntsweatherapp.model.network.forcasts

import com.lkb.ntsweatherapp.model.WeatherModel
import com.lkb.ntsweatherapp.model.network.WeatherApiService
import io.reactivex.Observable

class ForecastUseCase(weatherApiService: WeatherApiService) {
    private val mWeatherApiService = weatherApiService

    fun fetchForecast(key: String, place: String, forecastDays: Int): Observable<WeatherModel.WeatherApiResponse> {
        return mWeatherApiService.getWeatherForecast(key, place, forecastDays)
    }


}