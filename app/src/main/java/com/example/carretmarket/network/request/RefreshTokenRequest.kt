package com.example.carretmarket.network.request

import com.fasterxml.jackson.annotation.JsonProperty

data class RefreshTokenRequest(
    @JsonProperty
    val refreshToken: String
)