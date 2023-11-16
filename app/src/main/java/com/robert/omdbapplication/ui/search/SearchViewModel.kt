package com.robert.omdbapplication.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robert.omdbapplication.Constant.API_KEY
import com.robert.omdbapplication.data.NetworkRepository
import com.robert.omdbapplication.data.model.SearchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val networkRepository: NetworkRepository) :
    ViewModel() {

    private val _movieListMutableLiveData = MutableLiveData<SearchResponse>()
    val movieListLiveData: LiveData<SearchResponse> = _movieListMutableLiveData



    fun getMovieDetail(movieName: String) {
        viewModelScope.launch {
            val response = networkRepository.getSearchMovie(movieName, API_KEY)
            _movieListMutableLiveData.postValue(response.body())
        }
    }
}