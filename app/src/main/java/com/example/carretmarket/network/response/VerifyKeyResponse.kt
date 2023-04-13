package com.example.carretmarket.network.response

import com.fasterxml.jackson.annotation.JsonProperty

class VerifyKeyResponse(
    @JsonProperty
    val verificationToken: String,
    @JsonProperty
    val publicKey: String
)