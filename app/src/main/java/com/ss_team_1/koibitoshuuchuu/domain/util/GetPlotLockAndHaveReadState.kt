package com.ss_team_1.koibitoshuuchuu.domain.util

import com.ss_team_1.koibitoshuuchuu.presentation.MyApplication
import com.ss_team_1.koibitoshuuchuu.presentation.utils.CharacterInfoAndPlotStorer

class GetPlotLockAndHaveReadState {
    fun getPlotLockAndHaveReadState(
        characterID: Int
    ): List<PlotLockAndHaveReadStateAndTitle> {
//        val plotHaveReadState =
//            MyApplication.appContainer().plotRepository.getPlotByCharacterId(characterID).value!!
//        val characterLevel =
//            MyApplication.appContainer().characterRepository.getCharacter(characterID).value?.level()!!
        var output: List<PlotLockAndHaveReadStateAndTitle> = listOf()
//        val plotListSize = plotHaveReadState.size
//        val plot = CharacterInfoAndPlotStorer.character[characterID].plotList
//
//        for (i in 0..plotListSize) {
//            output = output + PlotLockAndHaveReadStateAndTitle(
//                lock = i < characterLevel,
//                haveRead = plotHaveReadState[i].seen,
//                title = plot[i].title
//            )
//        }

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