package com.example.carretmarket.network.response

data class VerifyKeyResponse(
    val verificationToken: String,
    val publicKey: String
)