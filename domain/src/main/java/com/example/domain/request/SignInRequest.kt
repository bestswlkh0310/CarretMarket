package com.example.domain.request

data class SignInRequest(
    val username: String,
    val password: String,
    val verificationToken: String
)