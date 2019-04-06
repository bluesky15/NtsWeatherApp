package com.lkb.ntsweatherapp.model

import com.lkb.ntsweatherapp.model.network.forcasts.ForecastUseCase
import io.reactivex.Observable

class Repositiory(forecastUseCase: ForecastUseCase) {
    var mForecastUseCase = forecastUseCase
    lateinit var weatherData: WeatherModel.WeatherApiResponse
    fun getWeatherDataFromServer(
        key: String,
        place: String,
        days: Int
    ): Observable<WeatherModel.WeatherApiResponse> {
        return mForecastUseCase.fetchForecast(key, place, days)

    }
}