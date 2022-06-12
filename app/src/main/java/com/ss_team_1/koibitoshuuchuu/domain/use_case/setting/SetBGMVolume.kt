package com.ss_team_1.koibitoshuuchuu.domain.use_case.setting

import com.ss_team_1.koibitoshuuchuu.domain.repository.SettingRepository

class SetBGMVolume(
    private val repository: SettingRepository
) {
    suspend operator fun invoke(newVolume: Int) {
        return repository.setBGMVolume(newVolume)
    }
}