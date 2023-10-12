package com.rafif.gamebargainhub.detail_deal

import androidx.lifecycle.ViewModel
import com.rafif.gamebargainhub.core.domain.model.Deal
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailDealViewModel @Inject constructor(private val dealUseCase: DealUseCase) : ViewModel() {
    fun setFavoriteDeal(deal: Deal, newStatus: Boolean) =
        dealUseCase.setFavoriteDeal(deal, newStatus)
}