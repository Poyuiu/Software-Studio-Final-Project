package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.setting.SettingUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.SettingEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.SettingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingUseCases: SettingUseCases
): ViewModel() {
    private val _state = mutableStateOf(SettingState())
    val state: State<SettingState> = _state

    private var getSettingJob: Job? = null

    init {
        getSetting()
    }

    fun onEvent(event: SettingEvent) {
        when (event) {
            is SettingEvent.SetBGMVolume -> {
                viewModelScope.launch {
                    settingUseCases.setBGMVolume(event.newVolume)
                }
            }
            is SettingEvent.SetKeepScreenOpen -> {
                viewModelScope.launch {
                    settingUseCases.setKeepScreenOpen(event.newValue)
                }
            }
            is SettingEvent.SetLanguage -> {
                viewModelScope.launch {
                    settingUseCases.setLanguage(event.newLanguage)
                }
            }
            is SettingEvent.SetRestrictedMode -> {
                viewModelScope.launch {
                    settingUseCases.setRestrictedMode(event.newValue)
                }
            }
            is SettingEvent.SetSoundEffectVolume -> {
                viewModelScope.launch {
                    settingUseCases.setSoundEffectVolume(event.newVolume)
                }
            }
        }
    }

    private fun getSetting() {
        getSettingJob?.cancel()
        getSettingJob = settingUseCases.getSetting()
            .onEach { setting ->
                _state.value = state.value.copy(
                    setting = setting
                )
            }
            .launchIn(viewModelScope)
    }
}