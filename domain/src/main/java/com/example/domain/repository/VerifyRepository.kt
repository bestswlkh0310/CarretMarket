package com.example.domain.repository

import com.example.domain.model.VerifyKey
import kotlinx.coroutines.flow.Flow

interface VerifyRepository {
    fun fetchVerifyKey(): Flow<VerifyKey>

    fun fetchVerifyEmail(): Flow<Unit>

    fun fetchVerifyEmailConfirm(code: String): Flow<Unit>
}