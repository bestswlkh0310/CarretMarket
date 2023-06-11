package com.example.domain.usecase.board

import com.example.domain.model.Board
import com.example.domain.repository.BoardRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class PostBoard @Inject constructor(
    private val repository: BoardRepository
) {
    fun invoke(board: Board)/*: String*/ {
/*        return CoroutineScope(Dispatchers.IO).async {
            repository.postBoard(
                board.id,
                board.timestamp,
                board.title
            )
        }.await()*/
    }
}