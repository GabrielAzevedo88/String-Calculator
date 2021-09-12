package com.mube.stringcalculator.application

import android.app.Application
import com.mube.stringcalculator.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupDependencies()
    }

    private fun setupDependencies() {
        startKoin {
            androidContext(this@AppApplication)
            modules(AppModule.all)
        }
    }

}