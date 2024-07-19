package com.example.android_tp.auth

import com.example.android_tp.api.APIResponse
import com.example.android_tp.api.RetrofitTools.Companion.retrofit
import com.example.android_tp.movie.Movie
import com.example.android_tp.movie.MovieService
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    /**
     * Appel l'url BASE_URL + "auth" (ex : locahost:3000/auth)
     * Envoie dans le body {email, password} car LoginRequest email et password
     * Retourne code, message, data? : APIReponse<T> possède code, message, data
     */
    @POST("auth")
    suspend fun auth(@Body loginRequest: LoginRequest) : APIResponse<String>

    object AuthApi {
        val authService : AuthService by lazy { retrofit.create(AuthService::class.java) }
    }
}