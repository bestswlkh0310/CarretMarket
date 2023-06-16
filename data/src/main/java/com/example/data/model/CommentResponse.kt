package com.example.data.model

data class CommentResponse(
    val id: Long,
    val author: String,
    val content: String,
    val timestamp: Long,
    val editStamp: Long?
)
