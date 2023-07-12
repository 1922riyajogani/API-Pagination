package com.example.apipagination.API

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        var token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YTk5YjZkMDcxZjkwMjY3MGFmYWQ1ZTNlZmZkMmZiNiIsInN1YiI6IjYzZDc2YjY1MjBlNmE1MDA4OTBkNTkyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.zFJRzC2mOd0UKf3yhigXoQrd2wHD9TzZSBWmDxEZMyE"
        val BASE_URL = "https://api.themoviedb.org/3/movie/"
        val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        lateinit var retrofit: Retrofit

        var client = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            chain.proceed(newRequest)
        }.build()


        fun getApiClient(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit
        }

    }

}