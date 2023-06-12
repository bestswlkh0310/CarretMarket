package com.example.data.service

import com.example.data.base.BaseResponse
import com.example.data.model.TokenResponse
import com.example.domain.request.RefreshTokenRequest
import com.example.domain.request.SignInRequest
import com.example.domain.request.SignUpRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/v1/sign/in")
    suspend fun login(@Body request: SignInRequest): BaseResponse<TokenResponse>
    @POST("api/v1/sign/up")
    suspend fun register(@Body request: SignUpRequest): BaseResponse<Unit>
    @POST("api/v1/sign/refresh")
    suspend fun refresh(@Body request: RefreshTokenRequest): BaseResponse<TokenResponse>
}