package com.rafif.gamebargainhub.core.di

import android.content.Context
import androidx.room.Room
import com.rafif.gamebargainhub.core.data.source.local.room.DealDao
import com.rafif.gamebargainhub.core.data.source.local.room.DealDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): DealDatabase = Room.databaseBuilder(
        context,
        DealDatabase::class.java, "Deal.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideDealDao(database: DealDatabase): DealDao = database.dealDao()
}