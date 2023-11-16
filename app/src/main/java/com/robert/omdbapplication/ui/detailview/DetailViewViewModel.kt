package com.robert.omdbapplication.ui.detailview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robert.omdbapplication.Constant
import com.robert.omdbapplication.data.NetworkRepository
import com.robert.omdbapplication.data.model.MovieDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewViewModel @Inject constructor(private val networkRepository: NetworkRepository) :
    ViewModel() {

    private val _movieDetailMutableLiveData = MutableLiveData<MovieDetailResponse>()
    val movieDetailLiveData: LiveData<MovieDetailResponse> = _movieDetailMutableLiveData

    fun getMovieDetail(imdbId: String) {
        viewModelScope.launch {
            val response = networkRepository.getMovieDetail(imdbId, Constant.API_KEY)
            _movieDetailMutableLiveData.postValue(response.body())
        }
    }

}