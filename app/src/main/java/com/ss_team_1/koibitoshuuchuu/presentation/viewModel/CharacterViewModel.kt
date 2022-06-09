package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.CharacterUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.CharacterEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterUseCases: CharacterUseCases
): ViewModel() {
    private val _state = mutableStateOf(CharacterState())
    val state: State<CharacterState> = _state

    private var getCharactersJob: Job? = null

    init {
        getCharacters()
    }

    fun onEvent(event: CharacterEvent) {
        when (event) {
            is CharacterEvent.UpdateIntimacy -> {
                viewModelScope.launch {
                    characterUseCases.updateIntimacy(event.id, event.changeAmount)
                }
            }
        }
    }

    private fun getCharacters() {
        getCharactersJob?.cancel()
        getCharactersJob = characterUseCases.getAllCharacter()
            .onEach { character ->
                _state.value = state.value.copy(
                    characters = character
                )
            }
            .launchIn(viewModelScope)
    }
}