package com.example.carretmarket.utils.retrofit.impl

import com.example.carretmarket.data.response.VerifyKeyResponse
import retrofit2.Call
import retrofit2.http.POST

interface VerifyAPI {
    @POST("api/v1/verifykey")
    fun fetchVerifyKey(): Call<VerifyKeyResponse>
}