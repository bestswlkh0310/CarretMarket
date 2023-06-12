package com.example.domain.usecase.board

import com.example.domain.model.Board
import com.example.domain.repository.BoardRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetBoard @Inject constructor(
    private val repository: BoardRepository
) {
    operator fun invoke(id: Long?): Flow<Board> {
        return repository.getBoardById(id)
    }
}