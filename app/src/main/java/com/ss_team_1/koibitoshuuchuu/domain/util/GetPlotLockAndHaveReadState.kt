package com.ss_team_1.koibitoshuuchuu.domain.util

import androidx.hilt.navigation.compose.hiltViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.MyApplication
import com.ss_team_1.koibitoshuuchuu.presentation.utils.ResourceStorer
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.CharacterViewModel
import com.ss_team_1.koibitoshuuchuu.presentation.viewModel.PlotStateViewModel

class GetPlotLockAndHaveReadState {
    fun getPlotLockAndHaveReadState(
        characterID: Int,
        characterViewModel: CharacterViewModel,
        plotStateViewModel: PlotStateViewModel
    ): List<PlotLockAndHaveReadStateAndTitle> {
        val plotHaveReadState = plotStateViewModel.state.value.plotState[characterID]
        val characterLevel = characterViewModel.state.value.characters[characterID].level
        var output: List<PlotLockAndHaveReadStateAndTitle> = listOf()
        val plotListSize = plotHaveReadState.size
        val plot = ResourceStorer.character[characterID].plotList

        for (i in 0 until plotListSize) {
            output = output + PlotLockAndHaveReadStateAndTitle(
                lock = i >= characterLevel,
                haveRead = plotHaveReadState[i].seen,
                title = plot[i].title
            )
        }

        return output
    }
}

class PlotLockAndHaveReadStateAndTitle {
    val lock: Boolean
    val haveRead: Boolean
    val title: Int

    constructor(lock: Boolean, haveRead: Boolean, title: Int) {
        this.lock = lock
        this.haveRead = haveRead
        this.title = title
    }
}