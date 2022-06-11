package com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState

import com.ss_team_1.koibitoshuuchuu.domain.model.PlotState
import com.ss_team_1.koibitoshuuchuu.domain.repository.PlotStateRepository
import kotlinx.coroutines.flow.Flow

class GetPlotState(
    private val repository: PlotStateRepository
) {
    operator fun invoke(): Flow<List<List<PlotState>>> {
        return repository.getPlotState()
    }
}