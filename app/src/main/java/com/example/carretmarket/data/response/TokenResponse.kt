package com.example.carretmarket.data.response

import com.fasterxml.jackson.annotation.JsonProperty

data class TokenResponse(
    @JsonProperty
    val accessToken: String,
    @JsonProperty
    val refreshToken: String,
    @JsonProperty
    val expireAfter: Long
)