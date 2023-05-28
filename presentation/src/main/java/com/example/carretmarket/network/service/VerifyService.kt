package com.example.carretmarket.network.service

import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.response.VerifyKeyResponse
import retrofit2.Call
import retrofit2.http.GET

interface VerifyService {
    @GET("api/v1/verify/key")
    fun fetchVerifyKey(): Call<BaseResponse<VerifyKeyResponse>>

    @GET("api/v1/verify/email")
    fun fetchVerifyEmail(): Call<BaseResponse<Unit>>

    @GET("api/v1/verify/email")
    fun fetchVerifyEmailConfirm(): Call<BaseResponse<Unit>>
}