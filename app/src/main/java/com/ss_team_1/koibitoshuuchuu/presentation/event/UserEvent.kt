package com.ss_team_1.koibitoshuuchuu.presentation.event

import java.util.*

sealed class UserEvent {
    data class SetId(val newId: Long): UserEvent()
    data class SetUserName(val newName: String): UserEvent()
    data class SetPhotoUrl(val newUrl: String): UserEvent()
    data class SetGender(val newGender: String): UserEvent()
    data class SetBirthday(val newBirthday: Calendar): UserEvent()
    data class SetJoinDate(val newJoinDate: Calendar): UserEvent()
    data class UpdateMoney(val changeAmount: Int): UserEvent()
    data class UpdateGem(val changeAmount: Int): UserEvent()
    data class SetLastUsedCharacterId(val id: Int): UserEvent()
}