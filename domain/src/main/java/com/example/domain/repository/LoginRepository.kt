package com.example.domain.repository

import com.example.domain.model.Token
import com.example.domain.request.RefreshTokenRequest
import com.example.domain.request.SignInRequest
import com.example.domain.request.SignUpRequest
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(request: SignInRequest): Flow<Token>

    fun register(request: SignUpRequest): Flow<Unit>

    fun refresh(request: RefreshTokenRequest): Flow<Token>
}