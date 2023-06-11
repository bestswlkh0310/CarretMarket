package com.example.data.mapper

import com.example.data.model.BoardListResponse
import com.example.data.model.BoardResponse
import com.example.domain.model.Board
import com.example.domain.model.BoardList

fun BoardListResponse.toEntity(): BoardList {
    return BoardList(
        this.id,
        this.timestamp,
        this.title
    )
}

fun BoardResponse.toEntity(): Board {
    return Board(
        this.id,
        this.timestamp,
        this.title
    )}