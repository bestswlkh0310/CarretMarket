package com.example.carretmarket.network.request

import com.fasterxml.jackson.annotation.JsonProperty

class NewBoardRequest (
    @JsonProperty val title: String,
    @JsonProperty val content: String
)