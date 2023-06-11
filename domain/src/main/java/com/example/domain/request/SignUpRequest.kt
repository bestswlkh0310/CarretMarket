package com.example.domain.request

data class SignUpRequest(
    val username: String,
    val email: String,
    val password: String,
    val verificationToken: String
)