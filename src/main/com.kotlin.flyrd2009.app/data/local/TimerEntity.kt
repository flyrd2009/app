package com.yourname.silencer.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "silence_timers")
data class TimerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val label: String,
    val startTimeUtc: Long,      // Start time in Unix Milliseconds (UTC)
    val endTimeUtc: Long,        // End time in Unix Milliseconds (UTC)
    val isActive: Boolean = true,
    val originalRingerMode: Int = -1 // To remember if it was Vibrate or Loud
)