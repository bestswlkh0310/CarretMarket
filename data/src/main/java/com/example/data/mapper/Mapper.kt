package com.example.data.mapper

import com.example.data.model.BoardListResponse
import com.example.data.model.BoardResponse
import com.example.data.model.TokenResponse
import com.example.data.model.VerifyKeyResponse
import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.model.Token
import com.example.domain.model.VerifyKey

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
        this.title,
        this.content,
        this.author,
        this.timestamp,
        this.editstamp
    )}

fun TokenResponse.toEntity(): Token {
    return Token(
        this.accessToken,
        this.refreshToken,
        this.expiresAt
    )
}

fun VerifyKeyResponse.toEntity(): VerifyKey {
    return VerifyKey(
        this.verificationToken,
        this.publicKey
    )
}