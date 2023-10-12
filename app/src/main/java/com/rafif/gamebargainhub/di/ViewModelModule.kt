package com.rafif.gamebargainhub.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafif.gamebargainhub.core.ui.ViewModelFactory
import com.rafif.gamebargainhub.detail_deal.DetailDealViewModel
import com.rafif.gamebargainhub.favorite.FavoriteViewModel
import com.rafif.gamebargainhub.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailDealViewModel::class)
    abstract fun bindDetailDealViewModel(viewModel: DetailDealViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}