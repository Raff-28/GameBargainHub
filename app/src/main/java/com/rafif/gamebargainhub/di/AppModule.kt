package com.rafif.gamebargainhub.di

import com.rafif.gamebargainhub.core.domain.usecase.DealInteractor
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideDealUseCase(dealInteractor: DealInteractor): DealUseCase

}