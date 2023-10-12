package com.rafif.gamebargainhub.core.di

import android.content.Context
import com.rafif.gamebargainhub.core.data.source.DealRepositoryImpl
import com.rafif.gamebargainhub.core.data.source.local.LocalDataSource
import com.rafif.gamebargainhub.core.data.source.local.room.DealDatabase
import com.rafif.gamebargainhub.core.data.source.remote.RemoteDataSource
import com.rafif.gamebargainhub.core.data.source.remote.network.ApiConfig
import com.rafif.gamebargainhub.core.domain.repository.DealRepository
import com.rafif.gamebargainhub.core.domain.usecase.DealInteractor
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import com.rafif.gamebargainhub.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): DealRepository {
        val database = DealDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.dealDao())
        val appExecutors = AppExecutors()

        return DealRepositoryImpl.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideDealUseCase(context: Context): DealUseCase {
        val repository = provideRepository(context)
        return DealInteractor(repository)
    }
}