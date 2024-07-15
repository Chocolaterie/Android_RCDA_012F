package com.example.android_tp.movie

import com.example.android_tp.api.RetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface MovieService {

    @GET("movies.json")
    suspend fun getMovies() : List<Movie>

    object MovieApi {
        val movieService : MovieService by lazy { retrofit.create(MovieService::class.java) }
    }
}