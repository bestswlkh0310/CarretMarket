package com.example.data.service

import com.example.data.base.BaseResponse
import com.example.data.model.VerifyKeyResponse
import retrofit2.Call
import retrofit2.http.GET

interface VerifyService {
    @GET("api/v1/verify/key")
    suspend fun fetchVerifyKey(): Call<BaseResponse<VerifyKeyResponse>>

    @GET("api/v1/verify/email")
    suspend fun fetchVerifyEmail(): Call<BaseResponse<Unit>>

    @GET("api/v1/verify/email")
    suspend fun fetchVerifyEmailConfirm(): Call<BaseResponse<Unit>>
}