package com.example.domain.usecase.board

import com.example.domain.repository.BoardRepository
import com.example.domain.request.PatchBoardRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PatchBoard @Inject constructor(
    private val boardRepository: BoardRepository
) {
    operator fun invoke(id: Long, patchBoardRequest: PatchBoardRequest): Flow<Unit> {
        return boardRepository.patchBoard(id, patchBoardRequest)
    }
}