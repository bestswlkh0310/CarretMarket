package com.example.data.datasource

import com.example.domain.model.VerifyKey
import kotlinx.coroutines.flow.Flow

interface VerifyDataSource {
    fun fetchVerifyKey(): Flow<VerifyKey>

    fun fetchVerifyEmail(): Flow<Unit>

    fun fetchVerifyEmailConfirm(code: String): Flow<Unit>
}