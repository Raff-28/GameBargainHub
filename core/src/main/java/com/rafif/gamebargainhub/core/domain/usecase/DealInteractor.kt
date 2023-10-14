package com.rafif.gamebargainhub.core.domain.usecase

import com.rafif.gamebargainhub.core.domain.model.Deal
import com.rafif.gamebargainhub.core.domain.repository.DealRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DealInteractor @Inject constructor(private val dealRepository: DealRepository): DealUseCase {

    override fun getAllDeal() = dealRepository.getAllDeal()

    override fun getFavoriteDeal(): Flow<List<Deal>> = dealRepository.getFavoriteDeal()

    override fun setFavoriteDeal(deal: Deal, state: Boolean) = dealRepository.setFavoriteDeal(deal, state)
}