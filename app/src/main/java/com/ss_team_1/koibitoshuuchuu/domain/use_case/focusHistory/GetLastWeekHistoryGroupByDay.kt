package com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory

import com.ss_team_1.koibitoshuuchuu.data.data_source.character.numOfCharacters
import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*
import kotlin.collections.LinkedHashMap

class GetLastWeekHistoryGroupByDay(
    private val repository: FocusHistoryRepository
) {
    operator fun invoke(): Flow<List<Map<Int, Float>>> {
        val dayStart = Calendar.getInstance()
        dayStart.set(Calendar.HOUR_OF_DAY, 0)
        dayStart.set(Calendar.MINUTE, 0)
        dayStart.set(Calendar.SECOND, 0)
        dayStart.set(Calendar.MILLISECOND, 0)
        val dayEnd: Calendar = dayStart.clone() as Calendar
        dayEnd.add(Calendar.DAY_OF_WEEK, 1)
        return repository.getLastWeekHistory()
            .map { histories ->
                List(numOfCharacters) { id ->
                    val list = List(7) {
                        var totalTime = 0f
                        histories.forEach { history ->
                            if (history.characterId == id && history.startTime >= dayStart && history.endTime <= dayEnd) {
                                totalTime += (history.endTime.timeInMillis - history.startTime.timeInMillis) / 3600000
                            }
                        }
                        val ret = Pair(dayStart.get(Calendar.DAY_OF_WEEK), totalTime)

                        dayStart.add(Calendar.DAY_OF_WEEK, -1)
                        dayEnd.add(Calendar.DAY_OF_WEEK, -1)

                        ret
                    }
                    val ret = LinkedHashMap<Int, Float>()
                    for (i in 6 downTo 0) {
                        ret[list[i].first] = list[i].second
                    }
                    ret
                }
        }
    }
}


