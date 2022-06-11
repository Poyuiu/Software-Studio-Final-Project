package com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState

import com.ss_team_1.koibitoshuuchuu.domain.repository.PlotStateRepository

class SetPlotState(
    private val repository: PlotStateRepository
) {
    operator fun invoke(characterId: Int, plotNum: Int) {
        repository.setPlotSeen(characterId, plotNum)
    }
}