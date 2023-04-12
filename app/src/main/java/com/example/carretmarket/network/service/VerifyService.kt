package com.example.carretmarket.network.service

import com.example.carretmarket.network.response.VerifyKeyResponse
import retrofit2.Call
import retrofit2.http.POST

interface VerifyService {
    @POST("api/v1/verifykey")
    fun fetchVerifyKey(): Call<VerifyKeyResponse>
}