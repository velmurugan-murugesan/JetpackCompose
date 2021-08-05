package com.velmurugan.jetpackcomposeexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

     @GET("movielist.json")
     suspend fun getMovieList() : List<Movie>

     companion object {

         private var apiService: ApiService? = null

         fun getInstance(): ApiService {
             if (apiService == null) {

                 apiService = Retrofit.Builder()
                     .baseUrl("https://howtodoandroid.com/apis/")
                     .addConverterFactory(GsonConverterFactory.create())
                     .build().create(ApiService::class.java)
             }
             return apiService!!
         }


     }

 }