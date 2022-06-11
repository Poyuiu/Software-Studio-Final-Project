package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.PlotState
import kotlinx.coroutines.flow.Flow

interface PlotStateRepository {
    fun getPlotState(): Flow<List<List<PlotState>>>
    fun setPlotSeenValue(characterId: Int, plotNum: Int, newValue: Boolean)
    fun setPlotSeen(characterId: Int, plotNum: Int)
}