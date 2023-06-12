package com.example.domain.model

data class BoardList (
    var id: Long,
    var timestamp: Long?,
    var title: String
)

fun BoardList.toBoard(): Board {
    return Board(
        this.id,
        this.timestamp,
        this.title
    )
}