package com.lkb.ntsweatherapp.di.application

import com.lkb.ntsweatherapp.di.presentation.PresentationComponent
import com.lkb.ntsweatherapp.di.presentation.PresentationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
fun newPresentationComponent(presentationModule: PresentationModule):PresentationComponent
}