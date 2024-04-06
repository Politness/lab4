package com.example.lab2.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val apiKey = "pj96zB0OxHNkIFBpCI8c1w==vW0InVFytqwxe1tl" // Replace this with your actual API key

    // Interceptor to add X-Api-Key header
    private val apiKeyInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()

        // Add X-Api-Key header to the request
        val requestWithApiKey = originalRequest.newBuilder()
            .header("X-Api-Key", apiKey)
            .build()

        chain.proceed(requestWithApiKey)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(apiKeyInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val instance = retrofit.create(CelebrityService::class.java)
}