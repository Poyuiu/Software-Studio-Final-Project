package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.setting.SettingDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Setting
import com.ss_team_1.koibitoshuuchuu.domain.repository.SettingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingRepositoryImplementation (
    private val settingDataStore: SettingDataStore
): SettingRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun getSetting(): LiveData<Setting> {
        return settingDataStore.settingDataFlow.asLiveData(coroutineScope.coroutineContext)
    }

    override fun setSoundEffectVolume(newVolume: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            settingDataStore.saveSoundEffectVolume(newVolume)
        }
    }

    override fun setBGMVolume(newVolume: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            settingDataStore.saveBGMVolume(newVolume)
        }
    }

    override fun setKeepScreenOpen(newValue: Boolean) {
        coroutineScope.launch(Dispatchers.IO) {
            settingDataStore.saveKeepScreenOpen(newValue)
        }
    }

    override fun setLanguage(newLanguage: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            settingDataStore.saveLanguage(newLanguage)
        }
    }

    override fun setRestrictedMode(newValue: Boolean) {
        coroutineScope.launch(Dispatchers.IO) {
            settingDataStore.saveRestrictedMode(newValue)
        }
    }


}