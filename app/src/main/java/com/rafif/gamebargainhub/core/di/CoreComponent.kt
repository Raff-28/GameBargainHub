package com.rafif.gamebargainhub.core.di

import android.content.Context
import com.rafif.gamebargainhub.core.domain.repository.DealRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): DealRepository
}