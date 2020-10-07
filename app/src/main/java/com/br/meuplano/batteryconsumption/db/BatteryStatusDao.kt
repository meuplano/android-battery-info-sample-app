package com.br.meuplano.batteryconsumption.db

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface BatteryStatusDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bStatus: BatteryStatus): Long

    @Query("DELETE FROM BatteryStatus")
    suspend fun deleteAll()

    @Query("SELECT * FROM BatteryStatus ORDER BY date desc")
    fun getAll(): LiveData<List<BatteryStatus>>

    @Query("SELECT * FROM BatteryStatus WHERE date BETWEEN :dateStart AND :dateEnt ORDER BY date desc")
    fun getBetweenDates(dateStart: Long, dateEnt: Long): LiveData<List<BatteryStatus>>
}