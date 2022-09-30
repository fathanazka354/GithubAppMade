package com.fathan.madegithub

import android.app.Application
import com.fathan.madegithub.core.di.useCaseModule
import com.fathan.madegithub.core.di.viewModelModule
import com.fathan.madegithub.di.databaseModule
import com.fathan.madegithub.di.networkModule
import com.fathan.madegithub.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}