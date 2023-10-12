package com.rafif.gamebargainhub.core.di

import com.rafif.gamebargainhub.core.data.source.DealRepositoryImpl
import com.rafif.gamebargainhub.core.domain.repository.DealRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(dealRepositoryImpl: DealRepositoryImpl): DealRepository

}