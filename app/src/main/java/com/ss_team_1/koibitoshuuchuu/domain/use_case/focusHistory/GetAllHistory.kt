package com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory

import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository
import kotlinx.coroutines.flow.Flow

class GetAllHistory (
    private val repository: FocusHistoryRepository
) {
    operator fun invoke(): Flow<List<FocusHistory>> {
        return repository.getAllHistory()
    }
}