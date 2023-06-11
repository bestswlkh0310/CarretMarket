package com.example.data.datasource

import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.request.NewBoardRequest
import kotlinx.coroutines.flow.Flow

interface BoardDataSource {
    fun getBoardById(
        id: Long?
    ): Flow<Board>

    fun getBoards(
        timestamp: Long?
    ): Flow<List<BoardList>>

    fun patchBoard(
        id: Long
    ): Flow<Unit>

    fun deleteBoard(
        id: Long
    ): Flow<Unit>

    fun postBoard(
        newBoardRequest: NewBoardRequest
    ): Flow<Board>
}