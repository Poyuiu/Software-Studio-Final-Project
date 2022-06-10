package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import kotlinx.coroutines.flow.Flow
import java.util.*

interface FocusHistoryRepository {
    fun getLastWeekHistory(): Flow<List<FocusHistory>>
    fun getAllHistory(): Flow<List<FocusHistory>>
    suspend fun insertHistory(characterId: Int, startTime: Calendar, endTime: Calendar)
}