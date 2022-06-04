package com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import java.util.*

@Dao
interface FocusHistoryDao {
    @Query("SELECT * FROM FocusHistory WHERE characterId=:id and startTime>:startTime ORDER BY startTime ASC")
    fun getLastWeekHistoryByCharacterId(id: Int, startTime: Long): LiveData<List<FocusHistory>>
    @Query("SELECT * FROM FocusHistory ORDER BY startTime DESC")
    fun getAllHistory(): LiveData<List<FocusHistory>>
    @Query("INSERT INTO FocusHistory (characterId, startTime, endTime) VALUES (:characterId, :startTime, :endTime)")
    fun insertHistory(characterId: Int, startTime: Calendar, endTime: Calendar)
}