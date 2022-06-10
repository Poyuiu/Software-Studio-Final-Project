package com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory

import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository
import java.util.*

class InsertHistory (
    private val repository: FocusHistoryRepository
) {
    suspend operator fun invoke(id: Int, startTime: Calendar, endTime: Calendar) {
        if (startTime.get(Calendar.DAY_OF_WEEK) != endTime.get(Calendar.DAY_OF_WEEK)) {
            val middleTime = endTime.clone() as Calendar
            middleTime.set(Calendar.HOUR_OF_DAY, 0)
            middleTime.set(Calendar.MINUTE, 0)
            middleTime.set(Calendar.SECOND, 0)
            middleTime.set(Calendar.MILLISECOND, 0)
            repository.insertHistory(id, middleTime, endTime)
            middleTime.timeInMillis--
            repository.insertHistory(id, startTime, middleTime)
        } else {
            repository.insertHistory(id, startTime, endTime)
        }
    }
}