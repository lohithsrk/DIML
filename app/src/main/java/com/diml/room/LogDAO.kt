package com.diml.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.diml.dataClass.LogEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface LogDAO {
    @Insert
    suspend fun addLog(log:LogEntity)

    @Update
    suspend fun updateLog(log:LogEntity)

    @Query("DELETE FROM Log WHERE id = :id")
    suspend fun deleteLog(id:Int)

    @Query("SELECT * FROM Log WHERE liked = 1")
    fun getLikedLogs():Flow<List<LogEntity>>

    @Query("SELECT * FROM Log WHERE date >= :currentDateTimeStart AND date <= :currentDateTimeEnd")
    fun getLogsPerDate(currentDateTimeStart: LocalDateTime,currentDateTimeEnd: LocalDateTime):Flow<List<LogEntity>>
}