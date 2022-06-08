package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.Plot

interface PlotRepository {
    fun getPlotByCharacterId(characterId: Int): LiveData<List<Plot>>
    fun getPlotByCharacterIdAndPlotNum(characterId: Int, plotNum: Int): LiveData<Plot>
    fun setPlotSeenValue(characterId: Int, plotNum: Int, newValue: Boolean)
    fun setPlotSeen(characterId: Int, plotNum: Int)
}