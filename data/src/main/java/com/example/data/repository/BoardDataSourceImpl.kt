package com.example.data.repository

import com.example.data.datasource.BoardDataSource
import com.example.data.mapper.toEntity
import com.example.data.service.BoardService
import com.example.domain.model.Board
import com.example.domain.model.BoardList
import com.example.domain.request.NewBoardRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

    override fun patchBoard(id: Long): Flow<Unit> {
        return flow {
            emit(boardService.patchBoard(id).data)
        }
    }

    override fun deleteBoard(id: Long): Flow<Unit> {
        return flow {
            emit(boardService.deleteBoard(id).data)
        }
    }

    override fun postBoard(newBoardRequest: NewBoardRequest): Flow<Board> {
        return flow {
            emit(boardService.postBoard(newBoardRequest).data.toEntity())
        }
    }
}