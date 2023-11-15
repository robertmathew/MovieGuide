package com.robert.omdbapplication.ui.detailview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.robert.omdbapplication.Constant
import com.robert.omdbapplication.data.APIClient
import com.robert.omdbapplication.data.ApiService
import com.robert.omdbapplication.data.model.MovieDetailResponse
import com.robert.omdbapplication.data.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewViewModel : ViewModel() {
    val retrofit = APIClient.client
    var apiService: ApiService = retrofit!!.create(ApiService::class.java)

    val _movieDetailMutableLiveData  = MutableLiveData<MovieDetailResponse>()
    val movieDetailLiveData: LiveData<MovieDetailResponse> = _movieDetailMutableLiveData

    fun movieDetail(imdbId: String) {

        val call: Call<MovieDetailResponse> = apiService.movieDetail(imdbId, Constant.API_KEY)

        call.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(call: Call<MovieDetailResponse>?, response: Response<MovieDetailResponse>) {
                val statusCode: Int = response.code()
                val data: MovieDetailResponse = response.body()!!

                _movieDetailMutableLiveData.value = data
            }

            override fun onFailure(call: Call<MovieDetailResponse>?, t: Throwable?) {

                // Log error here since request failed
            }
        })
    }
}