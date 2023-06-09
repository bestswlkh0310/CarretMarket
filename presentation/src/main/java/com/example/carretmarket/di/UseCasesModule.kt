package com.example.carretmarket.di

import com.example.domain.repository.BoardRepository
import com.example.domain.repository.CommentRepository
import com.example.domain.repository.LoginRepository
import com.example.domain.repository.VerifyRepository
import com.example.domain.usecase.board.BoardUseCases
import com.example.domain.usecase.board.DeleteBoard
import com.example.domain.usecase.board.GetBoard
import com.example.domain.usecase.board.GetBoards
import com.example.domain.usecase.board.PatchBoard
import com.example.domain.usecase.board.PostBoard
import com.example.domain.usecase.comment.CommentUseCases
import com.example.domain.usecase.comment.DeleteComment
import com.example.domain.usecase.comment.GetComments
import com.example.domain.usecase.comment.PatchComment
import com.example.domain.usecase.comment.PostComment
import com.example.domain.usecase.login.Login
import com.example.domain.usecase.login.LoginUseCases
import com.example.domain.usecase.login.Refresh
import com.example.domain.usecase.login.Register
import com.example.domain.usecase.verify.GetVerifyKey
import com.example.domain.usecase.verify.VerifyUseCases
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

    @Provides
    @Singleton
    fun provideVerifyUseCases(verifyRepository: VerifyRepository): VerifyUseCases {
        return VerifyUseCases(
            GetVerifyKey(verifyRepository)
        )
    }

    @Provides
    @Singleton
    fun provideLoginUseCases(loginRepository: LoginRepository): LoginUseCases {
        return LoginUseCases(
            Login(loginRepository),
            Register(loginRepository),
            Refresh(loginRepository)
        )
    }

    @Provides
    @Singleton
    fun provideCommentUseCases(commentRepository: CommentRepository): CommentUseCases {
        return CommentUseCases(
            GetComments(commentRepository),
            PostComment(commentRepository),
            PatchComment(commentRepository),
            DeleteComment(commentRepository)
        )
    }
}