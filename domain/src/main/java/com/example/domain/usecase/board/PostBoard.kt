package com.example.domain.usecase.board

import android.content.ContentValues.TAG
import android.util.Log
import com.example.domain.model.Board
import com.example.domain.repository.BoardRepository
import com.example.domain.request.NewBoardRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostBoard @Inject constructor(
    private val repository: BoardRepository
) {
    operator fun invoke(newBoardRequest: NewBoardRequest): Flow<Board> {
        Log.d(TAG, "PostBoard - invoke() called")
        return flow { repository.postBoard(newBoardRequest) }
    }
}