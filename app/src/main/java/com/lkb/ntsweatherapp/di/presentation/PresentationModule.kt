package com.lkb.ntsweatherapp.di.presentation

import android.app.Activity
import android.view.LayoutInflater
import com.lkb.ntsweatherapp.model.Repositiory
import com.lkb.ntsweatherapp.model.network.WeatherApiService
import com.lkb.ntsweatherapp.model.network.forcasts.ForecastUseCase
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
    fun getForcastUseCase(weatherApiService: WeatherApiService): ForecastUseCase {
        return ForecastUseCase(weatherApiService)
    }


    @Provides
    fun getRepository(mForecastUseCase: ForecastUseCase): Repositiory {
        return Repositiory(mForecastUseCase)
    }

    @Provides
    fun getAdapter(): MyAdapter {
        return MyAdapter()
    }
}
