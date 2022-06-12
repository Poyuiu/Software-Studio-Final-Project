package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.setting.SettingDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Setting
import com.ss_team_1.koibitoshuuchuu.domain.repository.SettingRepository
import kotlinx.coroutines.flow.Flow

class SettingRepositoryImplementation (
    private val settingDataStore: SettingDataStore
): SettingRepository {
    override fun getSetting(): Flow<Setting> {
        return settingDataStore.settingDataFlow
    }

    override suspend fun setSoundEffectVolume(newVolume: Int) {
        settingDataStore.saveSoundEffectVolume(newVolume)
    }

    override suspend fun setBGMVolume(newVolume: Int) {
        settingDataStore.saveBGMVolume(newVolume)
    }

    override suspend fun setKeepScreenOpen(newValue: Boolean) {
        settingDataStore.saveKeepScreenOpen(newValue)
    }

    override suspend fun setLanguage(newLanguage: Int) {
        settingDataStore.saveLanguage(newLanguage)
    }

    override suspend fun setRestrictedMode(newValue: Boolean) {
        settingDataStore.saveRestrictedMode(newValue)
    }


}