package com.example.domain.usecase.board

data class BoardUseCases (
    val getBoard: GetBoard,
    val postBoard: PostBoard,
    val getBoards: GetBoards,
    val deleteBoard: DeleteBoard,
    val patchBoard: PatchBoard
)