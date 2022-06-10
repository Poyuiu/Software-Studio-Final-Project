package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.data.data_source.character.numOfCharacters
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory

data class FocusHistoryState (
    val allHistories: List<FocusHistory> = emptyList(),
    val lastWeekHistories: List<List<FocusHistory>> = List(numOfCharacters) { emptyList() },
    val historiesGroupByDay: List<Map<Int, Float>> = List(numOfCharacters) {
        mapOf(
            1 to 0f,
            2 to 0f,
            3 to 0f,
            4 to 0f,
            5 to 0f,
            6 to 0f,
            7 to 0f
        )
    }
)