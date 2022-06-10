package com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory

import com.ss_team_1.koibitoshuuchuu.data.data_source.character.numOfCharacters
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetLastWeekHistory (
    private val repository: FocusHistoryRepository
) {
    operator fun invoke(): Flow<List<List<FocusHistory>>> {
        return repository.getLastWeekHistory()
            .map { histories ->
                List(numOfCharacters) { id ->
                    val ret = mutableListOf<FocusHistory>()
                    histories.forEach {
                        if (it.characterId == id)
                            ret.add(it)
                    }
                    ret.toList()
                }
            }
    }
}