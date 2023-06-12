package com.example.carretmarket.di

import com.example.data.datasource.BoardDataSource
import com.example.data.datasource.VerifyDataSource
import com.example.data.repository.BoardRepositoryImpl
import com.example.data.repository.VerifyRepositoryImpl
import com.example.domain.repository.BoardRepository
import com.example.domain.repository.VerifyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBoardRepository(boardDataSource: BoardDataSource): BoardRepository = BoardRepositoryImpl(boardDataSource)

    @Provides
    @Singleton
    fun provideVerifyRepository(verifyDataSource: VerifyDataSource): VerifyRepository = VerifyRepositoryImpl(verifyDataSource)
}