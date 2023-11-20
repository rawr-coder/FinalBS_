package com.example.finalbs_

import com.example.finalbs_.Comments
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {
    @GET("area")
    fun getComments(
        @Query("id") areaId: String,
        @Query("test") test: String
    ): Call<Comments>
}
