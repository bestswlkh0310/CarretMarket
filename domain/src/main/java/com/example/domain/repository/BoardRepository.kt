package com.example.domain.repository

import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.request.NewBoardRequest
import com.example.domain.request.PatchBoardRequest
import kotlinx.coroutines.flow.Flow

interface BoardRepository {

    fun getBoardById(
        id: Long?
    ): Flow<Board>

    fun getBoards(
        timestamp: Long?
    ): Flow<List<BoardList>>

    fun patchBoard(
        id: Long,
        patchBoardRequest: PatchBoardRequest
    ): Flow<Unit>

    fun deleteBoard(
        id: Long
    ): Flow<Unit>

    fun postBoard(
        newBoardRequest: NewBoardRequest
    ): Flow<Board>
}
