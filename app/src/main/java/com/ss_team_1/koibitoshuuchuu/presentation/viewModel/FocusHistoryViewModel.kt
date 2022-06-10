package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory.FocusHistoryUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.FocusHistoryEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.FocusHistoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FocusHistoryViewModel @Inject constructor(
    private val focusHistoryUseCases: FocusHistoryUseCases
): ViewModel() {
    private val _state = mutableStateOf(FocusHistoryState())
    val state: State<FocusHistoryState> = _state

    private var getAllHistoryJob: Job? = null
    private var getLastWeekHistoryJob: Job? = null
    private var getLastWeekHistoryGroupByDayJob: Job? = null

    init {
        getAllHistory()
        getLastWeekHistory()
        getLastWeekHistoryGroupByDay()
    }

    fun onEvent(event: FocusHistoryEvent) {
        when (event) {
            is FocusHistoryEvent.InsertHistory -> {
                viewModelScope.launch {
                    focusHistoryUseCases.insertHistory(event.characterId, event.startTime, event.endTime)
                }
            }
        }
    }

    private fun getAllHistory() {
        getAllHistoryJob?.cancel()
        getAllHistoryJob = focusHistoryUseCases.getAllHistory()
            .onEach { histories ->
                _state.value = state.value.copy(
                    allHistories = histories
                )
            }
            .launchIn(viewModelScope)
    }

    private fun getLastWeekHistory() {
        getLastWeekHistoryJob?.cancel()
        getLastWeekHistoryJob = focusHistoryUseCases.getLastWeekHistory()
            .onEach { histories ->
                _state.value = state.value.copy(
                    lastWeekHistories = histories
                )
            }
            .launchIn(viewModelScope)
    }
    private fun getLastWeekHistoryGroupByDay() {
        getLastWeekHistoryGroupByDayJob?.cancel()
        getLastWeekHistoryGroupByDayJob = focusHistoryUseCases.getLastWeekHistoryGroupByDay()
            .onEach { histories ->
                _state.value = state.value.copy(
                    historiesGroupByDay = histories
                )
            }
            .launchIn(viewModelScope)
    }
}