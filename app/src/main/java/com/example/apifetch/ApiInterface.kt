package com.example.apifetch

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("list")
    fun getData():Call<ArrayList<DataFileItem>>
}