package com.br.meuplano.batteryconsumption.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.meuplano.batteryconsumption.R
import com.br.meuplano.batteryconsumption.db.BatteryStatus
import kotlinx.android.synthetic.main.item_battery_consumption_fragment.view.*

class BatteryConsumptionListAdapter(
    private val batteryStatusItems: List<BatteryStatus>
) : RecyclerView.Adapter<BatteryConsumptionListAdapter.BatteryStatusListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatteryStatusListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_battery_consumption_fragment, parent, false)
        return BatteryStatusListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BatteryStatusListViewHolder, position: Int) {
        holder.bindView(batteryStatusItems.get(position))
    }

    override fun getItemCount(): Int {
        return batteryStatusItems.size
    }

    class BatteryStatusListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvCapacityRemainingPercentage: TextView = itemView.tvCapacityRemainingPercentage
        private val tvDate: TextView = itemView.tvDate
        private val tvHelth: TextView = itemView.tvHelth
        private val tvTemperature: TextView = itemView.tvTemperature
        private val tvPowerSource: TextView = itemView.tvPowerSource
        private val tvStatus: TextView = itemView.tvStatus

        fun bindView(itemBatteryStatus: BatteryStatus){
            with(itemBatteryStatus){
                tvCapacityRemainingPercentage.setText("${this.capacityRemainingPercentage}")
                tvDate.setText(this.date.toString())
                tvHelth.setText(this.helth.toString())
                tvTemperature.setText(this.temperature.toString())
                tvPowerSource.setText(this.powerSource.toString())
                tvStatus.setText(this.status.toString())
            }

        }
    }
}