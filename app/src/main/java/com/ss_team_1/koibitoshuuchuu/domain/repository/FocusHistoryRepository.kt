package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory

interface FocusHistoryRepository {
    fun getLastWeekHistoryByCharacterId(id: Int): LiveData<List<FocusHistory>>
    fun getAllHistory(): LiveData<List<FocusHistory>>
}