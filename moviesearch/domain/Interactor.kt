package com.example.moviesearch.domain

import androidx.lifecycle.LiveData
import com.example.moviesearch.data.*
import com.example.moviesearch.data.Entity.Film
import com.example.moviesearch.data.Entity.TmdbResults
import com.example.moviesearch.viewmodel.HomeFragmentViewModel
import com.example.moviesearch.utils.Converter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

    class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
        fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
            retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.Key, "ru-RU", page).enqueue(object : Callback<TmdbResults> {
                override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                    val list = Converter.convertApiListToDTOList(response.body()?.tmdbFilms)
                    list.forEach {
                        repo.putToDb(list)
                    }
                    callback.onSuccess()
                }

                override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                    callback.onFailure()
                }
            })
        }

        fun saveDefaultCategoryToPreferences(category: String) {
            preferences.saveDefaultCategory(category)
        }

        fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

        fun getFilmsFromDB(): LiveData<List<Film>>
        = repo.getAllFromDB()
    }


