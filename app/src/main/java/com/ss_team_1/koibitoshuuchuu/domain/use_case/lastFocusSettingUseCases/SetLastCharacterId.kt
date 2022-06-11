package com.ss_team_1.koibitoshuuchuu.domain.use_case.lastFocusSettingUseCases

import com.ss_team_1.koibitoshuuchuu.domain.repository.LastFocusSettingRepository

class SetLastCharacterId (
    private val repository: LastFocusSettingRepository
) {
    suspend operator fun invoke(id: Int) {
        repository.setCharacterId(id)
    }
}