package com.example.data.service

import com.example.data.base.BaseResponse
import com.example.data.model.VerifyKeyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VerifyService {
    @GET("api/v1/verify/key")
    suspend fun fetchVerifyKey(): BaseResponse<VerifyKeyResponse>

    @GET("api/v1/verify/email")
    suspend fun fetchVerifyEmail(): BaseResponse<Unit> // requires auth header

    @GET("api/v1/verify/email-confirm")
    suspend fun fetchVerifyEmailConfirm(
        @Query("code") code: String
    ): BaseResponse<Unit>
}