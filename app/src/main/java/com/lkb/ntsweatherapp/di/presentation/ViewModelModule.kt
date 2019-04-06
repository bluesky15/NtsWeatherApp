package com.lkb.ntsweatherapp.di.presentation

import com.lkb.ntsweatherapp.model.Repositiory
import com.lkb.ntsweatherapp.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule{
    @Provides
    fun getViewModelFactory(repository:Repositiory): ViewModelFactory {
        return ViewModelFactory(repository)
    }

}