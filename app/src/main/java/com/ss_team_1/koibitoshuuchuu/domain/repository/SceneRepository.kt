package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.Scene

interface SceneRepository {
    fun getAllScene(): LiveData<List<Scene>>
    fun getScene(id: Int): LiveData<Scene>
    fun setSceneIsOwned(id: Int, newValue: Boolean)
}