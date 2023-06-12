package com.example.domain.usecase.login

import com.example.domain.model.Token
import com.example.domain.repository.LoginRepository
import com.example.domain.request.RefreshTokenRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Refresh @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(request: RefreshTokenRequest): Flow<Token> {
        return loginRepository.refresh(request)
    }
}