package com.rafif.gamebargainhub.core.domain.usecase

import androidx.lifecycle.LiveData
import com.rafif.gamebargainhub.core.domain.model.Deal
import com.rafif.gamebargainhub.core.domain.repository.DealRepository

class DealInteractor(private val dealRepository: DealRepository): DealUseCase {

    override fun getAllDeal() = dealRepository.getAllDeal()

    override fun getFavoriteDeal(): LiveData<List<Deal>> = dealRepository.getFavoriteDeal()

    override fun setFavoriteDeal(deal: Deal, state: Boolean) = dealRepository.setFavoriteDeal(deal, state)
}