package com.example.carretmarket.network.request

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterRequest(
    @JsonProperty val username: String,
    @JsonProperty val password: String,
    @JsonProperty val verificationToken: String
)