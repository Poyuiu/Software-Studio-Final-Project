package com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory

data class FocusHistoryUseCases (
    val getLastWeekHistory: GetLastWeekHistory,
    val getLastWeekHistoryGroupByDay: GetLastWeekHistoryGroupByDay,
    val getAllHistory: GetAllHistory,
    val insertHistory: InsertHistory
)