package com.lkb.ntsweatherapp.di.presentation

import com.lkb.ntsweatherapp.model.Repository
import com.lkb.ntsweatherapp.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule{
    @Provides
    fun getViewModelFactory(repository:Repository): ViewModelFactory {
        return ViewModelFactory(repository)
    }

}