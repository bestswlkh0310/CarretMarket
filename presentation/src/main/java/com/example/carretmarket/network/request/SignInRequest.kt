package com.example.carretmarket.network.request

data class SignInRequest(
    val username: String,
    val password: String,
    val verificationToken: String
)