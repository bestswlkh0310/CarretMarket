package com.example.domain.usecase.login

import com.example.domain.model.Token
import com.example.domain.repository.LoginRepository
import com.example.domain.request.SignInRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Login @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(request: SignInRequest): Flow<Token> {
        return loginRepository.login(request)
    }
}