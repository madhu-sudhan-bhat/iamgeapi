package com.example.apifetch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.Observable
interface ApiInterface {
    @GET("list")
//    fun getData():Call<ArrayList<DataFileItem>>
    fun getData():Observable<ArrayList<DataFileItem>>
}