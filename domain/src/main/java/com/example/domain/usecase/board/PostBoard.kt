package com.example.domain.usecase.board

import com.example.domain.model.Board
import com.example.domain.repository.BoardRepository
import com.example.domain.request.NewBoardRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostBoard @Inject constructor(
    private val repository: BoardRepository
) {
    operator fun invoke(newBoardRequest: NewBoardRequest): Flow<Board> {
        return repository.postBoard(newBoardRequest)
    }
}