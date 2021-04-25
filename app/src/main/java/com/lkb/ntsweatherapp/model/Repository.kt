package com.lkb.ntsweatherapp.model

import com.lkb.ntsweatherapp.network.forcasts.WeatherUseCase
import com.lkb.ntsweatherapp.model.data.WeatherResponse
import io.reactivex.Observable

class Repository(weatherUseCase: WeatherUseCase) {
    var mForecastUseCase = weatherUseCase
    fun getWeatherFromServer(place:String, unit:String, key:String) :Observable<WeatherResponse.WeatherData>{
        return mForecastUseCase.fetchWeather(place,unit,key)
    }
}