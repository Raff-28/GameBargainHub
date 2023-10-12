package com.rafif.gamebargainhub.home

import androidx.lifecycle.ViewModel
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase

class HomeViewModel(dealUseCase: DealUseCase) : ViewModel() {
    val deals = dealUseCase.getAllDeal()
}