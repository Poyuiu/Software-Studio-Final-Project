package com.ss_team_1.koibitoshuuchuu.presentation.event

sealed class SceneEvent {
    data class SetScene(val id: Int, val newValue: Boolean): SceneEvent()
}