package com.example.data.repository

import android.util.Log
import com.example.data.datasource.BoardDataSource
import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.repository.BoardRepository
import com.example.domain.request.NewBoardRequest
import com.example.domain.request.PatchBoardRequest
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

    override fun patchBoard(id: Long, patchBoardRequest: PatchBoardRequest): Flow<Unit> {
        return boardDataSource.patchBoard(id, patchBoardRequest)
    }

    override fun deleteBoard(id: Long): Flow<Unit> {
        return boardDataSource.deleteBoard(id)
    }

    override fun postBoard(newBoardRequest: NewBoardRequest): Flow<Board> {
        Log.d("로그", "BoardRepositoryImpl - postBoard() called")
        return boardDataSource.postBoard(newBoardRequest)
    }
}