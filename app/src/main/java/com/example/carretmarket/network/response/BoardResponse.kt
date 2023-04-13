package com.example.carretmarket.network.response

import com.fasterxml.jackson.annotation.JsonProperty

class BoardResponse(
    @JsonProperty val id: Long,
    @JsonProperty val title: String,
    @JsonProperty val content: String,
    @JsonProperty val author: String,
    @JsonProperty val timestamp: Long,
    @JsonProperty val editStamp: Long?
)