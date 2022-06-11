package com.ss_team_1.koibitoshuuchuu.presentation.event

sealed class ItemEvent {
    data class UpdateOwnedQuantity(val id: Int, val changeAmount: Int): ItemEvent()
}