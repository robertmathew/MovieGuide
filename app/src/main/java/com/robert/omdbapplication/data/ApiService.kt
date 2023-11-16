package com.robert.omdbapplication.data

import com.robert.omdbapplication.data.model.MovieDetailResponse
import com.robert.omdbapplication.data.model.SearchResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET(".")
    suspend fun searchMovie(@Query("s") search: String, @Query("apikey") apiKey: String): Response<SearchResponse>

    @GET(".")
    suspend fun movieDetail(@Query("i") imdbId: String, @Query("apikey") apiKey: String): Response<MovieDetailResponse>
}