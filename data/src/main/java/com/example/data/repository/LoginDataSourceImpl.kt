package com.example.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.data.datasource.LoginDataSource
import com.example.data.mapper.toEntity
import com.example.data.service.LoginService
import com.example.domain.model.Token
import com.example.domain.request.RefreshTokenRequest
import com.example.domain.request.SignInRequest
import com.example.domain.request.SignUpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginService: LoginService
): LoginDataSource {
    override fun login(request: SignInRequest): Flow<Token> {
        return flow {
            emit(loginService.login(request).data.toEntity())
        }.flowOn(Dispatchers.IO)
    }

    override fun register(request: SignUpRequest): Flow<Unit> {
        return flow {
            emit(loginService.register(request).data)
        }.flowOn(Dispatchers.IO)
    }

    override fun refresh(request: RefreshTokenRequest): Flow<Token> {
        return flow {
            emit(loginService.refresh(request).data.toEntity())
        }.flowOn(Dispatchers.IO)
    }
}