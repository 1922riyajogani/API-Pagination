package com.example.apipagination.API

import com.example.apipagination.Models.UpcomingMovieModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("upcoming")
    fun getUpcoming() : Call<UpcomingMovieModel>

}