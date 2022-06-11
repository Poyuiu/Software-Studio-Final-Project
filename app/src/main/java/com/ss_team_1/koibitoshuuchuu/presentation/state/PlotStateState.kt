package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.data.data_source.character.numOfCharacters
import com.ss_team_1.koibitoshuuchuu.data.data_source.plot.maxNumOfPlot
import com.ss_team_1.koibitoshuuchuu.domain.model.PlotState

data class PlotStateState (
    val plotState: List<List<PlotState>> = List(numOfCharacters) { characterId ->
        List(maxNumOfPlot) { plotNum ->
            PlotState(characterId, plotNum, false)
        }
    }
)