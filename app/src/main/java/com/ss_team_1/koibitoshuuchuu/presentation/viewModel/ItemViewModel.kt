package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.item.ItemUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.ItemEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.ItemState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val itemUseCases: ItemUseCases
): ViewModel() {
    private val _state = mutableStateOf(ItemState())
    val state: State<ItemState> = _state

    private var getItemsJob: Job? = null

    init {
        getItems()
    }

    fun onEvent(event: ItemEvent) {
        when (event) {
            is ItemEvent.UpdateOwnedQuantity -> {
                viewModelScope.launch {
                    itemUseCases.updateItemOwnedQuantity(event.id, event.changeAmount)
                }
            }
        }
    }

    private fun getItems() {
        getItemsJob?.cancel()
        getItemsJob = itemUseCases.getAllItem()
            .onEach { item ->
                _state.value = state.value.copy(
                    Items = item
                )
            }
            .launchIn(viewModelScope)
    }
}