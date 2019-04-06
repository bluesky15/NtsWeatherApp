package com.lkb.ntsweatherapp.view.common

import androidx.annotation.UiThread
import androidx.fragment.app.FragmentActivity
import com.lkb.ntsweatherapp.MyApplication
import com.lkb.ntsweatherapp.di.application.ApplicationComponent
import com.lkb.ntsweatherapp.di.presentation.PresentationComponent
import com.lkb.ntsweatherapp.di.presentation.PresentationModule
import java.lang.RuntimeException

abstract class BaseActivity : FragmentActivity() {
    var mIsInjectorUsed: Boolean = false
    @UiThread
    protected fun getPresentationComponent(): PresentationComponent {
        if (mIsInjectorUsed) {
            throw RuntimeException("There is no need to use injector more than once")
        }
        mIsInjectorUsed = true
        return getApplicationComponent().newPresentationComponent(PresentationModule(this))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (application as MyApplication).getApplicationComponent()
    }
}