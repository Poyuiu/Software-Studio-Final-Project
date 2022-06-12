package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.data.data_source.scene.numOfScenes
import com.ss_team_1.koibitoshuuchuu.domain.model.Scene

data class SceneState (
    val scenes: List<Scene> = List(numOfScenes) {
        Scene(it, false)
    }
)