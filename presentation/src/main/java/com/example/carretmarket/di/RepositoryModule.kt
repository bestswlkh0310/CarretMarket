package com.example.carretmarket.di

import com.example.data.repository.BoardRepositoryImpl
import com.example.domain.repository.BoardRepository
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
    fun provideBoardRepository(boardRepositoryImpl: BoardRepositoryImpl): BoardRepository = boardRepositoryImpl

}