package com.rafif.gamebargainhub.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rafif.gamebargainhub.core.data.source.local.entity.DealEntity

@Dao
interface DealDao {
    @Query("SELECT * FROM deal")
    fun getAllDeal(): LiveData<List<DealEntity>>

    @Query("SELECT * FROM deal WHERE isFavorite = 1")
    fun getFavoriteDeal(): LiveData<List<DealEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDeal(deal: List<DealEntity>)

    @Update
    fun updateFavoriteDeal(deal: DealEntity)
}