package com.rafif.gamebargainhub.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(dealUseCase: DealUseCase) : ViewModel() {
    val favoriteDeals = dealUseCase.getFavoriteDeal().asLiveData()
}