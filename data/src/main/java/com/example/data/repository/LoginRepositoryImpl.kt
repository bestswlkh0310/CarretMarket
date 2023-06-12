package com.example.data.repository

import com.example.data.datasource.LoginDataSource
import com.example.domain.model.Token
import com.example.domain.repository.LoginRepository
import com.example.domain.request.RefreshTokenRequest
import com.example.domain.request.SignInRequest
import com.example.domain.request.SignUpRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
) : LoginRepository {
    override fun login(request: SignInRequest): Flow<Token> {
        return loginDataSource.login(request)
    }

    override fun register(request: SignUpRequest): Flow<Unit> {
        return loginDataSource.register(request)
    }

    override fun refresh(request: RefreshTokenRequest): Flow<Token> {
        return loginDataSource.refresh(request)
    }
}