package com.example.data.model


data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val expireAt: Long
)