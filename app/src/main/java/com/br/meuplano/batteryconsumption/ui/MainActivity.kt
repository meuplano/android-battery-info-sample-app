package com.br.meuplano.batteryconsumption.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.br.meuplano.batteryconsumption.BatteryUsageWorker
import com.br.meuplano.batteryconsumption.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private val viewModel: BatteryViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btResetService.setOnClickListener { resetServiceClick() }
        observeViewModelEvents()
        setupBatteryUsageWorker(ExistingPeriodicWorkPolicy.KEEP)
    }

    private fun observeViewModelEvents() {
        viewModel.batteryStatusEvent.observe(this@MainActivity) { itemList ->
            val adapter = BatteryConsumptionListAdapter(itemList)
            rvItems.run {
                this.setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    private fun resetServiceClick() {
        setupBatteryUsageWorker(ExistingPeriodicWorkPolicy.REPLACE)
    }

    private fun setupBatteryUsageWorker(existingPeriodicWorkPolicy: ExistingPeriodicWorkPolicy) {
        val batteryUsageWorkRequest =
            PeriodicWorkRequestBuilder<BatteryUsageWorker>(
                PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS,
                TimeUnit.MILLISECONDS
            )
                .build()

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            "UK_PERIODIC_BATTERY_USAGE",
            existingPeriodicWorkPolicy,
            batteryUsageWorkRequest
        )
    }
}