package com.rafif.gamebargainhub.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafif.gamebargainhub.core.data.source.local.entity.DealEntity

@Database(entities = [DealEntity::class], version = 1, exportSchema = false)
abstract class DealDatabase : RoomDatabase() {
    abstract fun dealDao(): DealDao

    companion object {
        @Volatile
        private var INSTANCE: DealDatabase? = null

        fun getInstance(context: Context): DealDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DealDatabase::class.java,
                    "Deal.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}