package com.example.carretmarket.data.request

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterRequest(
    @JsonProperty
    val username: String,
    @JsonProperty
    val password: String,
    @JsonProperty
    val verificationToken: String
)