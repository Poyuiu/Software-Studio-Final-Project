package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.plot.PlotDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Plot
import com.ss_team_1.koibitoshuuchuu.domain.repository.PlotRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlotRepositoryImplementation (
    private val plotDataStore: PlotDataStore
): PlotRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun getPlotByCharacterId(characterId: Int): LiveData<List<Plot>> {
        return plotDataStore.getPlotByCharacterId(characterId).asLiveData(coroutineScope.coroutineContext)
    }

    override fun getPlotByCharacterIdAndPlotNum(characterId: Int, plotNum: Int): LiveData<Plot> {
        return plotDataStore.getPlotByCharacterIdAndPlotNum(characterId, plotNum).asLiveData(coroutineScope.coroutineContext)
    }

    override fun setPlotSeenValue(characterId: Int, plotNum: Int, newValue: Boolean) {
        coroutineScope.launch(Dispatchers.IO) {
            plotDataStore.setSeen(characterId, plotNum, newValue)
        }
    }

    override fun setPlotSeen(characterId: Int, plotNum: Int) {
        setPlotSeenValue(characterId, plotNum, true)
    }

}