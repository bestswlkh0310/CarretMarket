package com.example.data.repository

import com.example.data.datasource.BoardDataSource
import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.repository.BoardRepository
import com.example.domain.request.NewBoardRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BoardRepositoryImpl @Inject constructor(
    private val boardDataSource: BoardDataSource
): BoardRepository {
    override fun getBoardById(id: Long?): Flow<Board> {
        return boardDataSource.getBoardById(id)
    }

    override fun getBoards(timestamp: Long?): Flow<List<BoardList>> {
        return boardDataSource.getBoards(timestamp)
    }

    override fun patchBoard(id: Long): Flow<Unit> {
        return boardDataSource.patchBoard(id)
    }

    override fun deleteBoard(id: Long): Flow<Unit> {
        return boardDataSource.deleteBoard(id)
    }

    override fun postBoard(newBoardRequest: NewBoardRequest): Flow<Board> {
        return boardDataSource.postBoard(newBoardRequest)
    }
}