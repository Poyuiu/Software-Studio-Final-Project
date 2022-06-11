package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.lastFocusSettingUseCases.LastFocusSettingUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.LastFocusSettingEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.LastFocusSettingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastFocusSettingViewModel @Inject constructor(
    private val lastFocusSettingUseCases: LastFocusSettingUseCases
): ViewModel() {
    private val _state = mutableStateOf(LastFocusSettingState())
    val state: State<LastFocusSettingState> = _state

    private var getLastFocusSettingJob: Job? = null

    init {
        getLastFocusSetting()
    }

    fun onEvent(event: LastFocusSettingEvent) {
        when (event) {
            is LastFocusSettingEvent.SetLastFocusTime -> {
                viewModelScope.launch {
                    lastFocusSettingUseCases.setLastFocusTime(event.time)
                }
            }
            is LastFocusSettingEvent.SetLastWork -> {
                viewModelScope.launch {
                    lastFocusSettingUseCases.setLastWork(event.work)
                }
            }
            is LastFocusSettingEvent.SetLastSceneId -> {
                viewModelScope.launch {
                    lastFocusSettingUseCases.setLastSceneId(event.id)
                }
            }
        }
    }

    private fun getLastFocusSetting() {
        getLastFocusSettingJob?.cancel()
        getLastFocusSettingJob = lastFocusSettingUseCases.getLastFocusSetting()
            .onEach { lastFocusSetting ->
                _state.value = state.value.copy(
                    lastFocusSetting = lastFocusSetting
                )
            }
            .launchIn(viewModelScope)
    }
}