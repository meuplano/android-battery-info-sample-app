package com.br.meuplano.batteryconsumption.db

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return if (date == null) null else date.getTime()
    }

    @TypeConverter
    fun fromIntToBatteryHelth(value: Int?): BatteryHelthType?{
        return if(value == null) null else BatteryHelthType.getByValue(value)
    }

    @TypeConverter
    fun fromBatteryHelthToInt(value: BatteryHelthType?): Int?{
        return if(value == null) null else value.value
    }

    @TypeConverter
    fun fromIntToBatteryPowerSource(value: Int?): BatteryPowerSourceType?{
        return if(value == null) null else BatteryPowerSourceType.getByValue(value)
    }

    @TypeConverter
    fun fromBatteryPowerSourceToInt(value: BatteryPowerSourceType?): Int?{
        return if(value == null) null else value.value
    }

    @TypeConverter
    fun fromIntToBatteryStatusType(value: Int?): BatteryStatusType?{
        return if(value == null) null else BatteryStatusType.getByValue(value)
    }

    @TypeConverter
    fun fromBatteryStatusTypeToInt(value: BatteryStatusType?): Int?{
        return if(value == null) null else value.value
    }

}