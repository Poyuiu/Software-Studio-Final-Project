package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.scene.SceneDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Scene
import com.ss_team_1.koibitoshuuchuu.domain.repository.SceneRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SceneRepositoryImplementation (
    private val sceneDataStore: SceneDataStore
): SceneRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun getAllScene(): LiveData<List<Scene>> {
        return sceneDataStore.sceneDataFlow.asLiveData(coroutineScope.coroutineContext)
    }

    override fun getScene(id: Int): LiveData<Scene> {
        return sceneDataStore.getScene(id).asLiveData(coroutineScope.coroutineContext)
    }

    override fun setSceneIsOwned(id: Int, newValue: Boolean) {
        coroutineScope.launch(Dispatchers.IO) {
            sceneDataStore.setOwned(id, newValue)
        }
    }
}