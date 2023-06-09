package com.example.data.datasource.impl

import com.example.data.datasource.VerifyDataSource
import com.example.data.mapper.toEntity
import com.example.data.model.VerifyKeyResponse
import com.example.data.service.VerifyService
import com.example.domain.model.VerifyKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class VerifyDataSourceImpl @Inject constructor(
    private val verifyService: VerifyService
) : VerifyDataSource {
    override fun fetchVerifyKey(): Flow<VerifyKey> {
        return flow {
            emit(verifyService.fetchVerifyKey().data.toEntity())
        }.flowOn(Dispatchers.IO)
    }

    override fun fetchVerifyEmail(): Flow<Unit> {
        return flow {
            emit(verifyService.fetchVerifyEmail().data)
        }.flowOn(Dispatchers.IO)
    }

    override fun fetchVerifyEmailConfirm(code: String): Flow<Unit> {
        return flow {
            emit(verifyService.fetchVerifyEmailConfirm(code).data)
        }.flowOn(Dispatchers.IO)
    }
}