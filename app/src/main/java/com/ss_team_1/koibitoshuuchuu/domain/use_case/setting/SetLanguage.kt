package com.ss_team_1.koibitoshuuchuu.domain.use_case.setting

import com.ss_team_1.koibitoshuuchuu.domain.repository.SettingRepository

class SetLanguage(
    private val repository: SettingRepository
) {
    suspend operator fun invoke(newLanguage: Int) {
        return repository.setLanguage(newLanguage)
    }
}