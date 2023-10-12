package com.rafif.gamebargainhub.detail_deal

import androidx.lifecycle.ViewModel
import com.rafif.gamebargainhub.core.domain.model.Deal
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import javax.inject.Inject

class DetailDealViewModel @Inject constructor(private val dealUseCase: DealUseCase) : ViewModel() {
    fun setFavoriteDeal(deal: Deal, newStatus: Boolean) =
        dealUseCase.setFavoriteDeal(deal, newStatus)
}