package com.example.domain.usecase.board

import com.example.domain.repository.BoardRepository
import javax.inject.Inject

data class BoardUseCases (
    val getBoard: GetBoard,
//    val postBoard: PostBoard
)