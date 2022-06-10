package com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface FocusHistoryDao {
    @Query("SELECT * FROM FocusHistory WHERE startTime>:startTime ORDER BY startTime DESC")
    fun getLastWeekHistory(startTime: Long): Flow<List<FocusHistory>>
    @Query("SELECT * FROM FocusHistory ORDER BY startTime DESC")
    fun getAllHistory(): Flow<List<FocusHistory>>
    @Query("INSERT INTO FocusHistory (characterId, startTime, endTime) VALUES (:characterId, :startTime, :endTime)")
    fun insertHistory(characterId: Int, startTime: Calendar, endTime: Calendar)
}