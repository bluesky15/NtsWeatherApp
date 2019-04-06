package com.lkb.ntsweatherapp.di.presentation

import com.lkb.ntsweatherapp.view.weather.WeatherActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class,ViewModelModule::class])
interface PresentationComponent{
    fun inject(activity: WeatherActivity)
}