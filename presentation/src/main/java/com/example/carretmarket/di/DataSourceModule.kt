package com.example.carretmarket.di

import com.example.data.datasource.BoardDataSource
import com.example.data.datasource.CommentDataSource
import com.example.data.datasource.LoginDataSource
import com.example.data.datasource.VerifyDataSource
import com.example.data.datasource.impl.BoardDataSourceImpl
import com.example.data.datasource.impl.CommentDataSourceImpl
import com.example.data.datasource.impl.LoginDataSourceImpl
import com.example.data.datasource.impl.VerifyDataSourceImpl
import com.example.data.service.BoardService
import com.example.data.service.CommentService
import com.example.data.service.LoginService
import com.example.data.service.VerifyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideBoardDataSource(boardService: BoardService): BoardDataSource = BoardDataSourceImpl(boardService)

    @Provides
    @Singleton
    fun provideVerifyDataSource(verifyService: VerifyService): VerifyDataSource = VerifyDataSourceImpl(verifyService)

    @Provides
    @Singleton
    fun provideLoginDataSource(loginService: LoginService): LoginDataSource = LoginDataSourceImpl(loginService)

    @Provides
    @Singleton
    fun provideCommentDataSource(commentService: CommentService): CommentDataSource = CommentDataSourceImpl(commentService)
}