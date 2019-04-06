package com.lkb.ntsweatherapp

import android.app.Application
import com.lkb.ntsweatherapp.di.application.ApplicationComponent
import com.lkb.ntsweatherapp.di.application.DaggerApplicationComponent


class MyApplication : Application() {
    lateinit var mApplicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder().build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return mApplicationComponent
    }
}