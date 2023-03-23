package com.example.moviesearch.di

import android.content.Context
import androidx.room.Room
import com.example.moviesearch.data.DAO.AppDatabase
import com.example.moviesearch.data.DAO.FilmDao
import com.example.moviesearch.data.DatabaseHelper
import com.example.moviesearch.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun  provideFilmDao(context: Context) =
    Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "film_db"
    ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}