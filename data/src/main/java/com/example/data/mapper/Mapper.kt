package com.example.data.mapper

import com.example.data.model.BoardListResponse
import com.example.data.model.BoardResponse
import com.example.data.model.TokenResponse
import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.model.Token

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

fun TokenResponse.toEntity(): Token {
    return Token(
        this.accessToken,
        this.refreshToken,
        this.expiresAt
    )
}