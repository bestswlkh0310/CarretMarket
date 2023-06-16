package com.example.domain.model

data class Comment (
    val id: Long,
    val author: String,
    val content: String,
    val timestamp: Long,
    val editStamp: Long?
)