package com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState

import com.ss_team_1.koibitoshuuchuu.domain.repository.PlotStateRepository

class SetPlotStateValue(
    private val repository: PlotStateRepository
) {
    operator fun invoke(characterId: Int, plotNum: Int, newValue: Boolean) {
        repository.setPlotSeenValue(characterId, plotNum, newValue)
    }
}