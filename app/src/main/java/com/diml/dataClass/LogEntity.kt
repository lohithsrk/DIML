package com.diml.dataClass

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "Log")
@RequiresApi(Build.VERSION_CODES.O)
data class LogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val date: LocalDateTime = LocalDateTime.now(),
    var liked: Boolean = false
)