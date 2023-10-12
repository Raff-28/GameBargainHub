package com.rafif.gamebargainhub.core.domain.usecase

import androidx.lifecycle.LiveData
import com.rafif.gamebargainhub.core.data.source.Resource
import com.rafif.gamebargainhub.core.domain.model.Deal

interface DealUseCase {
    fun getAllDeal(): LiveData<Resource<List<Deal>>>
    fun getFavoriteDeal(): LiveData<List<Deal>>
    fun setFavoriteDeal(deal: Deal, state: Boolean)
}