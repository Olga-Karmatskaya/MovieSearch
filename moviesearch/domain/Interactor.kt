package com.example.moviesearch.domain

import com.example.moviesearch.data.API
import com.example.moviesearch.data.Entity.TmdbResults
import com.example.moviesearch.data.MainRepository
import com.example.moviesearch.data.TmdbApi
import com.example.moviesearch.viewmodel.HomeFragmentViewModel
import com.example.moviesearch.utils.Converter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


    class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
        fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
            retrofitService.getFilms(API.Key, "ru-RU", page)
                .enqueue(object : Callback<TmdbResults> {
                    override fun onResponse(
                        call: Call<TmdbResults>,
                        response: Response<TmdbResults>
                    ) {
                        callback.onSuccess(Converter.convertApiListToDTOList(response.body()?.tmdbFilms))
                    }

                    override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                        callback.onFailure()
                    }
                })
        }
    }
