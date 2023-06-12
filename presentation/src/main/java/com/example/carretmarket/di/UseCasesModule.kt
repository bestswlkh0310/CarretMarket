package com.example.carretmarket.di

import com.example.domain.repository.BoardRepository
import com.example.domain.usecase.board.BoardUseCases
import com.example.domain.usecase.board.DeleteBoard
import com.example.domain.usecase.board.GetBoard
import com.example.domain.usecase.board.GetBoards
import com.example.domain.usecase.board.PatchBoard
import com.example.domain.usecase.board.PostBoard
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun provideBoardUseCases(boardRepository: BoardRepository): BoardUseCases {
        return BoardUseCases(
            GetBoard(boardRepository),
            PostBoard(boardRepository),
            GetBoards(boardRepository),
            DeleteBoard(boardRepository),
            PatchBoard(boardRepository),
        )
    }
}
