package com.rafif.gamebargainhub.core.data.source.local

import com.rafif.gamebargainhub.core.data.source.local.entity.DealEntity
import com.rafif.gamebargainhub.core.data.source.local.room.DealDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val dealDao: DealDao) {

    fun getAllDeal(): Flow<List<DealEntity>> = dealDao.getAllDeal()

    fun getFavoriteDeal(): Flow<List<DealEntity>> = dealDao.getFavoriteDeal()

    suspend fun insertDeal(dealList: List<DealEntity>) = dealDao.insertDeal(dealList)

    fun setFavoriteDeal(deal: DealEntity, newState: Boolean) {
        deal.isFavorite = newState
        dealDao.updateFavoriteDeal(deal)
    }
}