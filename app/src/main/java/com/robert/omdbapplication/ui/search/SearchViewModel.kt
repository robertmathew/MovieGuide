package com.robert.omdbapplication.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.robert.omdbapplication.Constant.API_KEY
import com.robert.omdbapplication.data.APIClient
import com.robert.omdbapplication.data.ApiService
import com.robert.omdbapplication.data.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    val retrofit = APIClient.client
    var apiService: ApiService = retrofit!!.create(ApiService::class.java)

    val _movieListMutableLiveData  = MutableLiveData<SearchResponse>()
    val movieListLiveData: LiveData<SearchResponse> = _movieListMutableLiveData

    fun searchMovie(movieName: String) {

        val call: Call<SearchResponse> = apiService.searchMovie(movieName, API_KEY)

        call.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>) {
                val statusCode: Int = response.code()
                val data: SearchResponse = response.body()!!

                _movieListMutableLiveData.value = data
            }

            override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {

                // Log error here since request failed
            }
        })
    }
}