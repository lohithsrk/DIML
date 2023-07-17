package com.diml.room

import android.os.Build
import androidx.annotation.RequiresApi
import com.diml.dataClass.LogEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class Repository(private val logDB: LogDB) {
    suspend fun addLog(logEntity: LogEntity) = logDB.logDAO().addLog(logEntity)

    suspend fun updateLog(logEntity: LogEntity) = logDB.logDAO().updateLog(logEntity)

    suspend fun deleteLog(id: Int) = logDB.logDAO().deleteLog(id)

    val likedLogs: Flow<List<LogEntity>> = logDB.logDAO().getLikedLogs()

    fun getLogsPerDate(
        currentDateTimeStart: LocalDateTime,
        currentDateTimeEnd: LocalDateTime
    ): Flow<List<LogEntity>> =
        logDB.logDAO().getLogsPerDate(currentDateTimeStart, currentDateTimeEnd)

}