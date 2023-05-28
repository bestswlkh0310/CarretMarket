package com.example.carretmarket.network.response


data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val expireAt: Long
)