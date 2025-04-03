package com.example.fetchmobileapp.di

import com.example.fetchmobileapp.data.repository.FetchItemsRepository
import com.example.fetchmobileapp.data.repository.FetchItemsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindFetchItemRepository(impl: FetchItemsRepositoryImpl): FetchItemsRepository
}