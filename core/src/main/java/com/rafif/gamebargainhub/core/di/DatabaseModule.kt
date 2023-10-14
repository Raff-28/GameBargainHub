package com.rafif.gamebargainhub.core.di

import android.content.Context
import androidx.room.Room
import com.rafif.gamebargainhub.core.data.source.local.room.DealDao
import com.rafif.gamebargainhub.core.data.source.local.room.DealDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DealDatabase = Room.databaseBuilder(
        context,
        DealDatabase::class.java, "Deal.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideDealDao(database: DealDatabase): DealDao = database.dealDao()
}