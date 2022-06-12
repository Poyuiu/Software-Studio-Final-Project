package com.ss_team_1.koibitoshuuchuu.domain.use_case.setting

import com.ss_team_1.koibitoshuuchuu.domain.model.Setting
import com.ss_team_1.koibitoshuuchuu.domain.repository.SettingRepository
import kotlinx.coroutines.flow.Flow

class GetSetting(
    private val repository: SettingRepository
) {
    operator fun invoke(): Flow<Setting> {
        return repository.getSetting()
    }
}