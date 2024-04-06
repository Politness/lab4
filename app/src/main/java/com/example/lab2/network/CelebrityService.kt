package com.example.lab2.network

import com.example.lab2.model.entity.Celebrity
import retrofit2.Call
import retrofit2.http.GET

interface CelebrityService {
    @GET("celebrity?name=all")
//    fun getCelebritiesByName(@Query("name") name: String): Call<List<Celebrity>>
    fun fetchCelebrityList(): Call<List<Celebrity>>
}