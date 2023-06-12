package com.example.domain.usecase.board

import com.example.domain.model.BoardList
import com.example.domain.repository.BoardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBoards @Inject constructor(
    private val boardRepository: BoardRepository
) {
    operator fun invoke(timestamp: Long?): Flow<List<BoardList>> {
        return boardRepository.getBoards(timestamp)
    }
}