package com.example.android_tp.movie

import com.example.android_tp.api.APIResponse
import com.example.android_tp.api.RetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface MovieService {

    @GET("v2/article/all")
    suspend fun getMovies() : APIResponse<List<Movie>>

    object MovieApi {
        val movieService : MovieService by lazy { retrofit.create(MovieService::class.java) }
    }
}