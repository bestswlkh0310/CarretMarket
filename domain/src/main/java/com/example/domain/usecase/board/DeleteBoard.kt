package com.example.domain.usecase.board

import com.example.domain.repository.BoardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteBoard @Inject constructor(
    private val boardRepository: BoardRepository
) {
    operator fun invoke(id: Long): Flow<Unit> {
        return boardRepository.deleteBoard(id)
    }
}