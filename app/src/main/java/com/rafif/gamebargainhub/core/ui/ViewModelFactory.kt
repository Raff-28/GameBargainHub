package com.rafif.gamebargainhub.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafif.gamebargainhub.core.di.Injection
import com.rafif.gamebargainhub.core.domain.usecase.DealUseCase
import com.rafif.gamebargainhub.detail_deal.DetailDealViewModel
import com.rafif.gamebargainhub.favorite.FavoriteViewModel
import com.rafif.gamebargainhub.home.HomeViewModel

class ViewModelFactory private constructor(private val dealUseCase: DealUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideDealUseCase(context)
                )
            }
    }

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