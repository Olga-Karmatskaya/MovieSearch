package com.example.moviesearch.data

import android.content.ContentValues
import android.database.Cursor
import androidx.lifecycle.LiveData
import com.example.moviesearch.data.DAO.FilmDao
import com.example.moviesearch.data.Entity.Film
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {

        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): LiveData<List<Film>> =
        filmDao.getCachedFilms()
    }
