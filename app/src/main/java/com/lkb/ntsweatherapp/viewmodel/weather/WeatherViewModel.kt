package com.lkb.ntsweatherapp.viewmodel.weather

import androidx.lifecycle.ViewModel
import com.lkb.ntsweatherapp.model.Repositiory
import com.lkb.ntsweatherapp.model.WeatherModel
import io.reactivex.Observable

class WeatherViewModel(
    repository: Repositiory
) : ViewModel() {
    var mWeatherData: WeatherModel.WeatherApiResponse? = null
    private var mRepository = repository

    fun callWeatherApi(key: String, place: String, days: Int): Observable<WeatherModel.WeatherApiResponse> {
        return mRepository.getWeatherDataFromServer(key, place, days)
    }
}