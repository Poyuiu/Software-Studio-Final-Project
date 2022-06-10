package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory.FocusHistoryDao
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository
import kotlinx.coroutines.flow.Flow
import java.util.*

class FocusHistoryRepositoryImplementation(
    private val dao: FocusHistoryDao
): FocusHistoryRepository {
    override fun getLastWeekHistory(): Flow<List<FocusHistory>> {
        val lastWeek = Calendar.getInstance()
        lastWeek.add(Calendar.DAY_OF_WEEK, -6)
        lastWeek.set(Calendar.HOUR_OF_DAY, 0)
        lastWeek.set(Calendar.MINUTE, 0)
        lastWeek.set(Calendar.SECOND, 0)
        lastWeek.set(Calendar.MILLISECOND, 0)
        return dao.getLastWeekHistory(lastWeek.timeInMillis)
    }

    override fun getAllHistory(): Flow<List<FocusHistory>> {
        return dao.getAllHistory()
    }

    override suspend fun insertHistory(characterId: Int, startTime: Calendar, endTime: Calendar) {
        dao.insertHistory(characterId, startTime, endTime)
    }
}