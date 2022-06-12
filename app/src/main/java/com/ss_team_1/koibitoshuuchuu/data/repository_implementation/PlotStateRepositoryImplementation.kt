package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.plot.PlotStateDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.PlotState
import com.ss_team_1.koibitoshuuchuu.domain.repository.PlotStateRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PlotStateRepositoryImplementation (
    private val plotStateDataStore: PlotStateDataStore
): PlotStateRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun getPlotState(): Flow<List<List<PlotState>>> {
        return plotStateDataStore.plotStateDataFlow
    }

    override fun setPlotSeenValue(characterId: Int, plotNum: Int, newValue: Boolean) {
        coroutineScope.launch(Dispatchers.IO) {
            plotStateDataStore.setSeen(characterId, plotNum, newValue)
        }
    }

    override fun setPlotSeen(characterId: Int, plotNum: Int) {
        setPlotSeenValue(characterId, plotNum, true)
    }

}