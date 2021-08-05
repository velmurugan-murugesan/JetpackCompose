package com.velmurugan.jetpackcomposeexample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {


    val movieResponse = MutableLiveData<List<Movie>>()


    fun getMovieDetails() {

        viewModelScope.launch {
            try {
                val response = ApiService.getInstance().getMovieList()
                Log.d("getMovieDetails", "${response.toString()}")
                movieResponse.postValue(response)
            } catch (e: Exception) {
                Log.d("Exception", "${e.message}")
            }

        }


    }
}