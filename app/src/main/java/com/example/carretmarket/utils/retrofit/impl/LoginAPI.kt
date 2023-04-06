package com.example.carretmarket.utils.retrofit.impl

import com.example.carretmarket.data.request.LoginRequest
import com.example.carretmarket.data.request.RefreshTokenRequest
import com.example.carretmarket.data.request.RegisterRequest
import com.example.carretmarket.data.response.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("api/v1/sign/in")
    fun login(@Body request: LoginRequest): Call<TokenResponse>
    @POST("api/v1/sign/up")
    fun register(@Body request: RegisterRequest): Call<Unit>
    @POST("api/v1/refresh")
    fun refresh(@Body request: RefreshTokenRequest): Call<TokenResponse>
}