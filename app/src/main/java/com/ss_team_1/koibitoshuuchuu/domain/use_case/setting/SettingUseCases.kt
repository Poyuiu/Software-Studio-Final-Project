package com.ss_team_1.koibitoshuuchuu.domain.use_case.setting

data class SettingUseCases (
    val getSetting: GetSetting,
    val setSoundEffectVolume: SetSoundEffectVolume,
    val setBGMVolume: SetBGMVolume,
    val setKeepScreenOpen: SetKeepScreenOpen,
    val setLanguage: SetLanguage,
    val setRestrictedMode: SetRestrictedMode
)