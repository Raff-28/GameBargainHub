package com.rafif.gamebargainhub.core.di

import com.rafif.gamebargainhub.core.data.source.DealRepositoryImpl
import com.rafif.gamebargainhub.core.domain.repository.DealRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(dealRepositoryImpl: DealRepositoryImpl): DealRepository

}