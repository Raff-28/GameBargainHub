package com.rafif.gamebargainhub.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(dealUseCase: DealUseCase) : ViewModel() {
    val deals = dealUseCase.getAllDeal().asLiveData()
}