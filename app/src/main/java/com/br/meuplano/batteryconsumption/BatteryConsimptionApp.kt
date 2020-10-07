package com.br.meuplano.batteryconsumption

import android.app.Application
import com.br.meuplano.batteryconsumption.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BatteryConsimptionApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@BatteryConsimptionApp)
            modules(mainModule)
        }
    }
}