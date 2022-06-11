package com.ss_team_1.koibitoshuuchuu.presentation.event

sealed class LastFocusSettingEvent {
    data class SetLastFocusTime(val time: Int): LastFocusSettingEvent()
    data class SetLastWork(val work: String): LastFocusSettingEvent()
    data class SetLastSceneId(val id: Int): LastFocusSettingEvent()
}