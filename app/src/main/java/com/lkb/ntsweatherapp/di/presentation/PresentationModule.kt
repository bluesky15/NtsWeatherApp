package com.lkb.ntsweatherapp.di.presentation

import android.app.Activity
import android.view.LayoutInflater
import com.lkb.ntsweatherapp.model.Repository
import com.lkb.ntsweatherapp.network.WeatherApiService
import com.lkb.ntsweatherapp.network.forcasts.WeatherUseCase
import com.lkb.ntsweatherapp.view.common.BaseActivity
import com.lkb.ntsweatherapp.view.weather.MyAdapter
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(baseActivity: BaseActivity) {
    private var mActivity = baseActivity

    @Provides
    fun getFragmentManager(): androidx.fragment.app.FragmentManager? {
        return mActivity.supportFragmentManager
    }

    @Provides
    fun getLayoutInflater(): LayoutInflater? {
        return LayoutInflater.from(mActivity)
    }

    @Provides
    fun getActivity(): Activity {
        return mActivity
    }

    @Provides
    fun getForcastUseCase(weatherApiService: WeatherApiService): WeatherUseCase {
        return WeatherUseCase(weatherApiService)
    }


    @Provides
    fun getRepository(mWeatherUseCase: WeatherUseCase): Repository {
        return Repository(mWeatherUseCase)
    }

    @Provides
    fun getAdapter(): MyAdapter {
        return MyAdapter()
    }
}
