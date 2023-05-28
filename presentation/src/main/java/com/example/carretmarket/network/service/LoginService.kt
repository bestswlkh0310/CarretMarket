package com.example.carretmarket.network.service

import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.request.SignUpRequest
import com.example.carretmarket.network.request.RefreshTokenRequest
import com.example.carretmarket.network.request.SignInRequest
import com.example.carretmarket.network.response.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/v1/sign/in")
    fun login(@Body request: SignInRequest): Call<BaseResponse<TokenResponse>>
    @POST("api/v1/sign/up")
    fun register(@Body request: SignUpRequest): Call<BaseResponse<Unit>>
    @POST("api/v1/sign/refresh")
    fun refresh(@Body request: RefreshTokenRequest): Call<BaseResponse<TokenResponse>>
}