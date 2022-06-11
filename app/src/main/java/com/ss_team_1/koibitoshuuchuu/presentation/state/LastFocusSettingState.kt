package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.domain.model.LastFocusSetting

data class LastFocusSettingState (
    val lastFocusSetting: LastFocusSetting = LastFocusSetting(0, "", 0)
)