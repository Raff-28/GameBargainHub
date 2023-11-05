package com.rafif.gamebargainhub.di

import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun dealUseCase(): DealUseCase
}