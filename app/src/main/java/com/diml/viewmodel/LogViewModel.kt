package com.diml.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diml.dataClass.LogEntity
import com.diml.room.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class LogViewModel(val repository: Repository) : ViewModel() {
    fun addLog(log: LogEntity) = viewModelScope.launch { repository.addLog(log) }

    fun updateLog(log: LogEntity) = viewModelScope.launch { repository.updateLog(log) }

    fun deleteLog(id: Int) = viewModelScope.launch { repository.deleteLog(id) }

    val likedLogs: Flow<List<LogEntity>> = repository.likedLogs

    fun logsPerDate(
        currentDateTimeStart: LocalDateTime,
        currentDateTimeEnd: LocalDateTime
    ): Flow<List<LogEntity>> = repository.getLogsPerDate(currentDateTimeStart, currentDateTimeEnd)


}