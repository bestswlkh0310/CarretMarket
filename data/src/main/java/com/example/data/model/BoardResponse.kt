package com.example.data.model

data class BoardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val author: String,
    val timestamp: Long,
    val editstamp: Long?
)