package com.diml.room

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diml.dataClass.LogEntity
import com.diml.utils.Converter

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [LogEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class LogDB : RoomDatabase() {
    abstract fun logDAO(): LogDAO

    companion object {
        @Volatile
        private var INSTANCE: LogDB? = null
        fun getInstance(context: Context): LogDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, LogDB::class.java, "log_db"
                    ).build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}