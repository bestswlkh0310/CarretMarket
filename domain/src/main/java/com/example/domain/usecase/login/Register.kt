package com.example.domain.usecase.login

import com.example.domain.repository.LoginRepository
import com.example.domain.request.SignUpRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Register @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(request: SignUpRequest): Flow<Unit> {
        return loginRepository.register(request)
    }
}