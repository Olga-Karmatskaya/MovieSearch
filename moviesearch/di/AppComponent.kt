package com.example.moviesearch.di

import com.example.moviesearch.viewmodel.HomeFragmentViewModel
import com.example.moviesearch.viewmodel.SettingsFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
modules = [
    RemoteModule::class,
    DatabaseModule::class,
    DomainModule::class
]
)

interface AppComponent {
    fun inject(homeFragmentViewModel : HomeFragmentViewModel)
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}
