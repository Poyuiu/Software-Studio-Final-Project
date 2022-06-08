package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.*
import com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory.FocusHistoryDatabase
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusDailyHistory
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
        lastWeek.add(Calendar.DAY_OF_WEEK, -6)
        lastWeek.set(Calendar.HOUR_OF_DAY, 0)
        lastWeek.set(Calendar.MINUTE, 0)
        lastWeek.set(Calendar.SECOND, 0)
        lastWeek.set(Calendar.MILLISECOND, 0)
        return dao.getLastWeekHistoryByCharacterId(id, lastWeek.timeInMillis)
    }

    override fun getLastWeekHistoryByCharacterIdGroupByDay(id: Int): LiveData<List<FocusDailyHistory>> {
        val dayStart = Calendar.getInstance()
        dayStart.set(Calendar.HOUR_OF_DAY, 0)
        dayStart.set(Calendar.MINUTE, 0)
        dayStart.set(Calendar.SECOND, 0)
        dayStart.set(Calendar.MILLISECOND, 0)
        val dayEnd: Calendar = dayStart.clone() as Calendar
        dayEnd.add(Calendar.DAY_OF_WEEK, 1)
        return getLastWeekHistoryByCharacterId(id)
            .map { histories ->
                List(7) {
                    var totalTime = 0f
                    histories.forEach { history ->
                        if (history.startTime >= dayStart && history.endTime <= dayEnd) {
                            totalTime += (history.endTime.timeInMillis-history.startTime.timeInMillis) / 3600000
                        }
                    }
                    val ret = FocusDailyHistory(id, dayStart.clone() as Calendar, totalTime)

                    dayStart.add(Calendar.DAY_OF_WEEK, -1)
                    dayEnd.add(Calendar.DAY_OF_WEEK, -1)

                    ret
                }
            }

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