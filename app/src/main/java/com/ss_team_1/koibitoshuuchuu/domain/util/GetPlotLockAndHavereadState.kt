package com.ss_team_1.koibitoshuuchuu.domain.util

import com.ss_team_1.koibitoshuuchuu.presentation.MyApplication
import com.ss_team_1.koibitoshuuchuu.presentation.utils.CharacterInfoAndPlotStorer
import com.ss_team_1.koibitoshuuchuu.presentation.utils.Plot

class GetPlotLockAndHavereadState {
    fun getPlotLockAndHavereadState(
        characterID: Int
    ): List<PlotLockAndHavereadStateAndTitle> {
        val plotHavereadState =
            MyApplication.appContainer().plotRepository.getPlotByCharacterId(characterID).value!!
        val characterLevel =
            MyApplication.appContainer().characterRepository.getCharacter(characterID).value?.level()!!
        var output: List<PlotLockAndHavereadStateAndTitle> = listOf()
        val plotListSize = plotHavereadState.size
        val plot = CharacterInfoAndPlotStorer.character[characterID].plotList

        for (i in 0..plotListSize) {
            output = output + PlotLockAndHavereadStateAndTitle(
                lock = i < characterLevel,
                haveRead = plotHavereadState[i].seen,
                title = plot[i].title
            )
        }

        return output
    }
}

class PlotLockAndHavereadStateAndTitle {
    val lock: Boolean
    val haveRead: Boolean
    val title: Int

    constructor(lock: Boolean, haveRead: Boolean, title: Int) {
        this.lock = lock
        this.haveRead = haveRead
        this.title = title
    }
}