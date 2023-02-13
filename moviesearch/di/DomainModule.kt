package com.example.moviesearch.di

import android.content.Context
import com.example.moviesearch.data.MainRepository
import com.example.moviesearch.data.PreferenceProvider
import com.example.moviesearch.data.TmdbApi
import com.example.moviesearch.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule (val  context: Context) {
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun providePreferences(context: Context) = PreferenceProvider(context)
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}