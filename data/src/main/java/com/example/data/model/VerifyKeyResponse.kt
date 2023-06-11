package com.example.data.model

data class VerifyKeyResponse(
    val verificationToken: String,
    val publicKey: String
)
