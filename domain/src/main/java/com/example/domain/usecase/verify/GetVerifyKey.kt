package com.example.domain.usecase.verify

import com.example.domain.model.VerifyKey
import com.example.domain.repository.VerifyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVerifyKey @Inject constructor(
    private val verifyRepository: VerifyRepository
) {
    operator fun invoke(): Flow<VerifyKey> {
        return verifyRepository.fetchVerifyKey()
    }
}