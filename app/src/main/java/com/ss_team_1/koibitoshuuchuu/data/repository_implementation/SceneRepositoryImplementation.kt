package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.scene.SceneDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Scene
import com.ss_team_1.koibitoshuuchuu.domain.repository.SceneRepository
import kotlinx.coroutines.flow.Flow

class SceneRepositoryImplementation (
    private val sceneDataStore: SceneDataStore
): SceneRepository {
    override fun getAllScene(): Flow<List<Scene>> {
        return sceneDataStore.sceneDataFlow
    }

    override suspend fun setSceneIsOwned(id: Int, newValue: Boolean) {
        sceneDataStore.setOwned(id, newValue)
    }
}