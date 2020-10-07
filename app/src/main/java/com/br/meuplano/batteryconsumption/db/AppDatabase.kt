package com.br.meuplano.batteryconsumption.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BatteryStatus::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun batteryDao(): BatteryStatusDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
            ).build()
        }
    }
}