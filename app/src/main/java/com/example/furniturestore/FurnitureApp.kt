package com.example.furniturestore

import android.app.Application
import com.example.furniturestore.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FurnitureApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@FurnitureApp)
            androidLogger()

            modules(appModule)
        }
    }
}