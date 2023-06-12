package com.example.domain.model

data class Token (
    val accessToken: String,
    val refreshToken: String,
    val expiresAt: Long
)