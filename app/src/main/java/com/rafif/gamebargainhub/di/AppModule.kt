package com.rafif.gamebargainhub.di

import com.rafif.gamebargainhub.core.domain.usecase.DealInteractor
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideDealUseCase(dealInteractor: DealInteractor): DealUseCase

}