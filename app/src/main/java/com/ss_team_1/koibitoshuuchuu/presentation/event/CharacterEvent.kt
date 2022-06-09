package com.ss_team_1.koibitoshuuchuu.presentation.event

sealed class CharacterEvent {
    data class UpdateIntimacy(val id: Int, val changeAmount: Int): CharacterEvent()
}
