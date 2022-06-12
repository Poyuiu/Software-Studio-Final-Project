package com.ss_team_1.koibitoshuuchuu.domain.use_case.setting

import com.ss_team_1.koibitoshuuchuu.domain.repository.SettingRepository

class SetKeepScreenOpen(
    private val repository: SettingRepository
) {
    suspend operator fun invoke(newValue: Boolean) {
        return repository.setKeepScreenOpen(newValue)
    }
}