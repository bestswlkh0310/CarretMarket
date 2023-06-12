package com.example.data.repository

import com.example.data.datasource.VerifyDataSource
import com.example.domain.model.VerifyKey
import com.example.domain.repository.VerifyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VerifyRepositoryImpl @Inject constructor(
    private val verifyDataSource: VerifyDataSource
) : VerifyRepository {
    override fun fetchVerifyKey(): Flow<VerifyKey> {
        return verifyDataSource.fetchVerifyKey()
    }

    override fun fetchVerifyEmail(): Flow<Unit> {
        return verifyDataSource.fetchVerifyEmail()
    }

    override fun fetchVerifyEmailConfirm(code: String): Flow<Unit> {
        return verifyDataSource.fetchVerifyEmailConfirm(code)
    }
}