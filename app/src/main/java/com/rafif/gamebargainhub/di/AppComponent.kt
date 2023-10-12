package com.rafif.gamebargainhub.di

import com.rafif.gamebargainhub.core.di.CoreComponent
import com.rafif.gamebargainhub.detail_deal.DetailDealActivity
import com.rafif.gamebargainhub.favorite.FavoriteActivity
import com.rafif.gamebargainhub.home.HomeActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: HomeActivity)
    fun inject(activity: FavoriteActivity)
    fun inject(activity: DetailDealActivity)
}