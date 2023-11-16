package com.robert.omdbapplication.data

import com.robert.omdbapplication.data.model.MovieDetailResponse
import com.robert.omdbapplication.data.model.SearchResponse
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    val apiService: ApiService
) {

    suspend fun getSearchMovie(search: String, apiKey: String): Response<SearchResponse> {
        return apiService.searchMovie(search, apiKey)
    }

    suspend fun getMovieDetail(imdbId: String, apiKey: String): Response<MovieDetailResponse> {
        return apiService.movieDetail(imdbId, apiKey)
    }
}