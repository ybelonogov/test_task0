package com.example.cft_test_task.Api

//import com.example.cft_test_task.binNumber
import com.example.cft_test_task.model.CardInfo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.http.Headers

interface ApiService  {
//    @Headers({"Accept-Version: 3"})
    @GET("{bin}")
//    Call<CardInfoItem> getCardInfo(@Path("bin") binNumber: String)
    suspend fun getCardInfo(@Path("bin") binNumber: String) :Response<CardInfo>

}