package com.rafif.gamebargainhub.core.domain.repository

import androidx.lifecycle.LiveData
import com.rafif.gamebargainhub.core.data.source.Resource
import com.rafif.gamebargainhub.core.data.source.local.entity.DealEntity
import com.rafif.gamebargainhub.core.domain.model.Deal

interface DealRepository {

    fun getAllDeal(): LiveData<Resource<List<Deal>>>

    fun getFavoriteDeal(): LiveData<List<Deal>>

    fun setFavoriteDeal(deal: Deal, state: Boolean)

}