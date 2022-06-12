package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.domain.model.Setting

data class SettingState (
    val setting: Setting = Setting(50, 50, true, 0, false)
)