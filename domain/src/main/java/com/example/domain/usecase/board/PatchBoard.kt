package com.example.domain.usecase.board

import com.example.domain.repository.BoardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PatchBoard @Inject constructor(
    private val boardRepository: BoardRepository
) {
    fun invoke(id: Long): Flow<Unit> {
        return boardRepository.patchBoard(id)
    }
}