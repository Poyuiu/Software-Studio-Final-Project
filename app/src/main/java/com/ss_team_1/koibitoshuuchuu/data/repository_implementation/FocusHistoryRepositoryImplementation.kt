package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.*
import com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory.FocusHistoryDatabase
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class FocusHistoryRepositoryImplementation(
    database: FocusHistoryDatabase
): FocusHistoryRepository {
    private val dao = database.focusHistoryDao()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun getLastWeekHistoryByCharacterId(id: Int): LiveData<List<FocusHistory>> {
        val lastWeek = Calendar.getInstance()
        lastWeek.add(Calendar.DAY_OF_WEEK, -7)
        lastWeek.set(Calendar.HOUR_OF_DAY, 0)
        lastWeek.set(Calendar.MINUTE, 0)
        lastWeek.set(Calendar.SECOND, 0)
        lastWeek.set(Calendar.MILLISECOND, 0)
        return dao.getLastWeekHistoryByCharacterId(id, lastWeek.timeInMillis)
    }

    override fun getAllHistory(): LiveData<List<FocusHistory>> {
        return dao.getAllHistory()
    }

    override fun insertHistory(characterId: Int, startTime: Calendar, endTime: Calendar) {
        coroutineScope.launch(Dispatchers.IO) {
            dao.insertHistory(characterId, startTime, endTime)
        }
    }
}