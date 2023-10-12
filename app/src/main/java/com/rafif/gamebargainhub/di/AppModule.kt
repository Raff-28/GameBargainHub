package com.rafif.gamebargainhub.di

import com.rafif.gamebargainhub.core.domain.usecase.DealInteractor
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideDealUseCase(dealInteractor: DealInteractor): DealUseCase

}