package com.ss_team_1.koibitoshuuchuu.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ss_team_1.koibitoshuuchuu.domain.use_case.user.UserUseCases
import com.ss_team_1.koibitoshuuchuu.presentation.event.UserEvent
import com.ss_team_1.koibitoshuuchuu.presentation.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCases: UserUseCases
): ViewModel() {
    private val _state = mutableStateOf(UserState())
    val state: State<UserState> = _state

    private var getUserInfoJob: Job? = null

    init {
        getUserInfo()
    }

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.SetId -> {
                viewModelScope.launch {
                    userUseCases.setId(event.newId)
                }
            }
            is UserEvent.SetUserName -> {
                viewModelScope.launch {
                    userUseCases.setUserName(event.newName)
                }
            }
            is UserEvent.SetPhotoUrl -> {
                viewModelScope.launch {
                    userUseCases.setPhotoUrl(event.newUrl)
                }
            }
            is UserEvent.SetGender -> {
                viewModelScope.launch {
                    userUseCases.setGender(event.newGender)
                }
            }
            is UserEvent.SetBirthday -> {
                viewModelScope.launch {
                    userUseCases.setBirthday(event.newBirthday)
                }
            }
            is UserEvent.SetJoinDate -> {
                viewModelScope.launch {
                    userUseCases.setJoinDate(event.newJoinDate)
                }
            }
            is UserEvent.UpdateMoney -> {
                viewModelScope.launch {
                    userUseCases.updateMoney(event.changeAmount)
                }
            }
            is UserEvent.UpdateGem -> {
                viewModelScope.launch {
                    userUseCases.updateGem(event.changeAmount)
                }
            }
            is UserEvent.SetLastUsedCharacterId -> {
                viewModelScope.launch {
                    userUseCases.setLastUsedCharacterId(event.id)
                }
            }
        }
    }

    private fun getUserInfo() {
        getUserInfoJob?.cancel()
        getUserInfoJob = userUseCases.getUserInfo()
            .onEach { userInfo ->
                _state.value = state.value.copy(
                    userInfo = userInfo
                )
            }
            .launchIn(viewModelScope)
    }
}