package com.lkb.ntsweatherapp.viewmodel.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lkb.ntsweatherapp.model.Repository
import com.lkb.ntsweatherapp.model.data.WeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(
    repository: Repository
) : ViewModel() {
    private var _mWeatherData = MutableLiveData<WeatherResponse.WeatherData>()
    var mWeatherData: LiveData<WeatherResponse.WeatherData> = _mWeatherData
    private var mRepository = repository


    fun callWeather(
        place: String,
        unit: String,
        key: String
    ) {
        mRepository.getWeatherFromServer(place, unit, key).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _mWeatherData.postValue(it)
            }
    }
}