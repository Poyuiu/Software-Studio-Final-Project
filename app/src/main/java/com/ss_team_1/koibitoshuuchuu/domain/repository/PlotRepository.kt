package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.PlotState

interface PlotRepository {
    fun getPlotByCharacterId(characterId: Int): LiveData<List<PlotState>>
    fun getPlotByCharacterIdAndPlotNum(characterId: Int, plotNum: Int): LiveData<PlotState>
    fun setPlotSeenValue(characterId: Int, plotNum: Int, newValue: Boolean)
    fun setPlotSeen(characterId: Int, plotNum: Int)
}