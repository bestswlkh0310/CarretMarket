package com.example.carretmarket.data.request

import com.fasterxml.jackson.annotation.JsonProperty

data class RefreshTokenRequest(
    @JsonProperty
    val refreshToken: String
)