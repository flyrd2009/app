package com.yourname.silencer.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TimerDao {
    @Query("SELECT * FROM silence_timers ORDER BY startTimeUtc ASC")
    fun getAllTimers(): Flow<List<TimerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimer(timer: TimerEntity): Long

    @Delete
    suspend fun deleteTimer(timer: TimerEntity)

    @Query("SELECT * FROM silence_timers WHERE isActive = 1 AND :currentTime BETWEEN startTimeUtc AND endTimeUtc")
    suspend fun getActiveTimers(currentTime: Long): List<TimerEntity>
}