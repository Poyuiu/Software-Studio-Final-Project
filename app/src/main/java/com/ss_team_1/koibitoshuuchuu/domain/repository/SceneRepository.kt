package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.Scene
import kotlinx.coroutines.flow.Flow

interface SceneRepository {
    fun getAllScene(): Flow<List<Scene>>
    suspend fun setSceneIsOwned(id: Int, newValue: Boolean)
}