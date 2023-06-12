package com.example.carretmarket.di

import com.example.data.repository.BoardDataSourceImpl
import com.example.data.service.BoardService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun provideBoardDataSource(boardService: BoardService): BoardDataSourceImpl = BoardDataSourceImpl(boardService)
}