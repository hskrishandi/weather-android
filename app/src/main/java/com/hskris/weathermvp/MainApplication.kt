package com.hskris.weathermvp

import android.app.Application
import com.hskris.weathermvp.di.weatherAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()
            androidContext(this@MainApplication)
            androidFileProperties()
            modules(weatherAppModule)
        }

    }

}