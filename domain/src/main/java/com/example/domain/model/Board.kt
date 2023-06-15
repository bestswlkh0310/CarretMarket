package com.example.domain.model

data class Board(
    val id: Long,
    val title: String,
    val content: String,
    val author: String,
    val timestamp: Long,
    val editstamp: Long?
)