package com.br.meuplano.batteryconsumption.di

import com.br.meuplano.batteryconsumption.db.AppDatabase
import com.br.meuplano.batteryconsumption.db.BatteryStatusDao
import com.br.meuplano.batteryconsumption.ui.BatteryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single<BatteryStatusDao> {
        AppDatabase.getInstance(
            context = androidContext()
        ).batteryDao()
    }

    viewModel {
        BatteryViewModel(get())
    }
}