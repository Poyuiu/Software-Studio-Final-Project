package com.ss_team_1.koibitoshuuchuu.domain.use_case.lastFocusSettingUseCases

import com.ss_team_1.koibitoshuuchuu.domain.model.LastFocusSetting
import com.ss_team_1.koibitoshuuchuu.domain.repository.LastFocusSettingRepository
import kotlinx.coroutines.flow.Flow

class GetLastFocusSetting (
    private val repository: LastFocusSettingRepository
) {
    operator fun invoke(): Flow<LastFocusSetting> {
        return repository.getLastFocusSetting()
    }
}