package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.scene.SceneUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.SceneEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.SceneState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SceneViewModel @Inject constructor(
    private val sceneUseCases: SceneUseCases
): ViewModel() {
    private val _state = mutableStateOf(SceneState())
    val state: State<SceneState> = _state

    private var getSceneJob: Job? = null

    init {
        getScenes()
    }

    fun onEvent(event: SceneEvent) {
        when(event) {
            is SceneEvent.SetScene -> {
                viewModelScope.launch {
                    sceneUseCases.setSceneIsOwned(event.id, event.newValue)
                }
            }
        }
    }

    private fun getScenes() {
        getSceneJob?.cancel()
        getSceneJob = sceneUseCases.getAllScene()
            .onEach { scene ->
                _state.value = state.value.copy(
                    scenes = scene
                )
            }
            .launchIn(viewModelScope)
    }
}