package com.example.domain.model

data class VerifyKey (
    val verificationToken: String,
    val publicKey: String
)
