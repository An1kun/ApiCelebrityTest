package com.example.apicelebritytest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CelebrityApiService {
    @GET("Celebrity")
    fun getCelebrity(@Query("name") name: String, @Query("X-Api-Key") apiKey: String): Call<List<Celebrity>>
}