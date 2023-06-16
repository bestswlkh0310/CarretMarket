package com.example.data.datasource.impl

import android.content.ContentValues.TAG
import android.util.Log
import com.example.data.datasource.BoardDataSource
import com.example.data.mapper.toEntity
import com.example.data.service.BoardService
import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.request.NewBoardRequest
import com.example.domain.request.PatchBoardRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class BoardDataSourceImpl @Inject constructor(
    private val boardService: BoardService
): BoardDataSource {
    override fun getBoardById(id: Long?): Flow<Board> {
        return flow {
            emit(boardService.getBoardById(id).data.toEntity())
        }.flowOn(Dispatchers.IO)
    }

    override fun getBoards(timestamp: Long?): Flow<List<BoardList>> {
        return flow {
            emit(boardService.getBoards(timestamp).data.map { it.toEntity() } )
        }.flowOn(Dispatchers.IO)
    }

    override fun patchBoard(id: Long, patchBoardRequest: PatchBoardRequest): Flow<Unit> {
        return flow {
            emit(boardService.patchBoard(id, patchBoardRequest).data)
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteBoard(id: Long): Flow<Unit> {
        return flow {
            emit(boardService.deleteBoard(id).data)
        }.flowOn(Dispatchers.IO)
    }

    override fun postBoard(newBoardRequest: NewBoardRequest): Flow<Board> {
        CoroutineScope(Dispatchers.IO).launch {
            boardService.postBoard(newBoardRequest)
        }
        Log.d(TAG, "BoardDataSourceImpl - postBoard() called")
        return flow {
            emit(boardService.postBoard(newBoardRequest).data.toEntity())
        }.flowOn(Dispatchers.IO)
    }
}