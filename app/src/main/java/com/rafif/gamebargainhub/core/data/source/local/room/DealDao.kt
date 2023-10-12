package com.rafif.gamebargainhub.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rafif.gamebargainhub.core.data.source.local.entity.DealEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DealDao {
    @Query("SELECT * FROM deal")
    fun getAllDeal(): Flow<List<DealEntity>>

    @Query("SELECT * FROM deal WHERE isFavorite = 1")
    fun getFavoriteDeal(): Flow<List<DealEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDeal(deal: List<DealEntity>)

    @Update
    fun updateFavoriteDeal(deal: DealEntity)
}