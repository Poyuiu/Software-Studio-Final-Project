package com.ss_team_1.koibitoshuuchuu.presentation.event

import java.util.*

sealed class FocusHistoryEvent {
    data class InsertHistory(val characterId: Int, val startTime: Calendar, val endTime: Calendar): FocusHistoryEvent()
}
