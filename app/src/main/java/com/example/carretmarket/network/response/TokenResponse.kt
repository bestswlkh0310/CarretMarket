package com.example.carretmarket.network.response

import com.fasterxml.jackson.annotation.JsonProperty

data class TokenResponse(
    @JsonProperty val accessToken: String,
    @JsonProperty val refreshToken: String,
    @JsonProperty val expireAt: Long
)