package com.rafif.gamebargainhub.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafif.gamebargainhub.core.data.source.local.entity.DealEntity

@Database(entities = [DealEntity::class], version = 1, exportSchema = false)
abstract class DealDatabase : RoomDatabase() {
    abstract fun dealDao(): DealDao
}