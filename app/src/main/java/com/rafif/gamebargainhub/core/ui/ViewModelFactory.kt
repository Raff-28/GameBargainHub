package com.rafif.gamebargainhub.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import com.rafif.gamebargainhub.detail_deal.DetailDealViewModel
import com.rafif.gamebargainhub.di.AppScope
import com.rafif.gamebargainhub.favorite.FavoriteViewModel
import com.rafif.gamebargainhub.home.HomeViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val dealUseCase: DealUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(dealUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(dealUseCase) as T
            }
            modelClass.isAssignableFrom(DetailDealViewModel::class.java) -> {
                DetailDealViewModel(dealUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

}