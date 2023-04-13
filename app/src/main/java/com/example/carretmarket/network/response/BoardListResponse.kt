package com.example.carretmarket.network.response

import com.fasterxml.jackson.annotation.JsonProperty

class BoardListResponse (
    @JsonProperty val boards: Array<Pair<String, String>>
)