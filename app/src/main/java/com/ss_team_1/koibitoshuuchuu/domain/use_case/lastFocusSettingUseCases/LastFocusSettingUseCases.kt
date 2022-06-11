package com.ss_team_1.koibitoshuuchuu.domain.use_case.lastFocusSettingUseCases

data class LastFocusSettingUseCases (
    val getLastFocusSetting: GetLastFocusSetting,
    val setLastCharacterId: SetLastCharacterId,
    val setLastFocusTime: SetLastFocusTime,
    val setLastWork: SetLastWork,
    val setLastSceneId: SetLastSceneId
)