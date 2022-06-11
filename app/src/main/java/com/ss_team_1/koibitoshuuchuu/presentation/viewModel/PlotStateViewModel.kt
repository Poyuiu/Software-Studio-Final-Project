package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState.PlotStateUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.PlotStateEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.PlotStateState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlotStateViewModel @Inject constructor(
    private val plotStateUseCases: PlotStateUseCases
): ViewModel() {
    private val _state = mutableStateOf(PlotStateState())
    val state: State<PlotStateState> = _state

    private var getPlotStateJob: Job? = null
    init {
        getPlotState()
    }

    fun onEvent(event: PlotStateEvent) {
        when(event) {
            is PlotStateEvent.SetPlotState -> {
                viewModelScope.launch {
                    plotStateUseCases.setPlotState(event.characterId, event.plotNum)
                }
            }
            is PlotStateEvent.SetPlotStateValue -> {
                viewModelScope.launch {
                    plotStateUseCases.setPlotStateValue(event.characterId, event.plotNum, event.newValue)
                }
            }
        }
    }

    fun getPlotState() {
        getPlotStateJob?.cancel()
        getPlotStateJob = plotStateUseCases.getPlotState()
            .onEach { plotState ->
                _state.value = state.value.copy(
                    plotState = plotState
                )
            }
            .launchIn(viewModelScope)
    }
}