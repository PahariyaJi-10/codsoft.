package com.divyansh.alarmclockapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Insert
    suspend fun insertAlarm(
        alarm: AlarmEntity
    )

    @Delete
    suspend fun deleteAlarm(
        alarm: AlarmEntity
    )

    @Query("SELECT * FROM alarms")
    fun getAllAlarms(): Flow<List<AlarmEntity>>
}