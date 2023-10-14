package com.rafif.gamebargainhub.core.domain.repository

import com.rafif.gamebargainhub.core.data.source.Resource
import com.rafif.gamebargainhub.core.domain.model.Deal
import kotlinx.coroutines.flow.Flow

interface DealRepository {

    fun getAllDeal(): Flow<Resource<List<Deal>>>

    fun getFavoriteDeal(): Flow<List<Deal>>

    fun setFavoriteDeal(deal: Deal, state: Boolean)

}