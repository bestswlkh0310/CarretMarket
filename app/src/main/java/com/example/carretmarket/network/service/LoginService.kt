package com.example.carretmarket.network.service

import com.example.carretmarket.network.request.LoginRequest
import com.example.carretmarket.network.request.RefreshTokenRequest
import com.example.carretmarket.network.request.RegisterRequest
import com.example.carretmarket.network.response.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/v1/sign/in")
    fun login(@Body request: LoginRequest): Call<TokenResponse>
    @POST("api/v1/sign/up")
    fun register(@Body request: RegisterRequest): Call<Unit>
    @POST("api/v1/refresh")
    fun refresh(@Body request: RefreshTokenRequest): Call<TokenResponse>
}