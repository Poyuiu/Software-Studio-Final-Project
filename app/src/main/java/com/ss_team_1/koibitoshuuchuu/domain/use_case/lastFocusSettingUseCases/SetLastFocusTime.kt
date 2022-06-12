package com.ss_team_1.koibitoshuuchuu.domain.use_case.lastFocusSettingUseCases

import com.ss_team_1.koibitoshuuchuu.domain.repository.LastFocusSettingRepository

class SetLastFocusTime (
    private val repository: LastFocusSettingRepository
) {
    suspend operator fun invoke(time: Int) {
        repository.setFocusTime(time)
    }
}