package com.example.carretmarket.network.response

import com.fasterxml.jackson.annotation.JsonProperty

class BoardListResponse (
    /**
     * boards: (id, title)
     * id -> GET board
     */
    @JsonProperty val boards: Map<String, String>
)