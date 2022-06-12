package com.ss_team_1.koibitoshuuchuu.presentation.event

sealed class SettingEvent {
    data class SetBGMVolume(val newVolume: Int): SettingEvent()
    data class SetKeepScreenOpen(val newValue: Boolean): SettingEvent()
    data class SetLanguage(val newLanguage: Int): SettingEvent()
    data class SetRestrictedMode(val newValue: Boolean): SettingEvent()
    data class SetSoundEffectVolume(val newVolume: Int): SettingEvent()
}