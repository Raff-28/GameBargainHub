package com.rafif.gamebargainhub

import android.app.Application
import com.rafif.gamebargainhub.core.di.CoreComponent
import com.rafif.gamebargainhub.core.di.DaggerCoreComponent
import com.rafif.gamebargainhub.di.AppComponent
import com.rafif.gamebargainhub.di.DaggerAppComponent

open class MyApplication: Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}