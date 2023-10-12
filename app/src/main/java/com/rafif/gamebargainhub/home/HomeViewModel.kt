package com.rafif.gamebargainhub.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(dealUseCase: DealUseCase) : ViewModel() {
    val deals = dealUseCase.getAllDeal().asLiveData()
}