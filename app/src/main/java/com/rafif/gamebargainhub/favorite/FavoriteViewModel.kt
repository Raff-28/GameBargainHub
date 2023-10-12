package com.rafif.gamebargainhub.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase

class FavoriteViewModel(dealUseCase: DealUseCase) : ViewModel() {
    val favoriteDeals = dealUseCase.getFavoriteDeal().asLiveData()
}