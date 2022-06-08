package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusDailyHistory
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import java.util.*

interface FocusHistoryRepository {
    fun getLastWeekHistoryByCharacterId(id: Int): LiveData<List<FocusHistory>>
    fun getLastWeekHistoryByCharacterIdGroupByDay(id: Int): LiveData<List<FocusDailyHistory>>
    fun getAllHistory(): LiveData<List<FocusHistory>>
    fun insertHistory(characterId: Int, startTime: Calendar, endTime: Calendar)
}