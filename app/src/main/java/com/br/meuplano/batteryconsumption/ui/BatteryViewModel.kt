package com.br.meuplano.batteryconsumption.ui

import androidx.lifecycle.ViewModel
import com.br.meuplano.batteryconsumption.db.BatteryStatusDao

class BatteryViewModel(
    repository: BatteryStatusDao
): ViewModel() {
    val batteryStatusEvent = repository.getAll()
}