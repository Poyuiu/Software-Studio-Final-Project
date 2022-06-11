package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.lastFocusSetting.LastFocusSettingDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.LastFocusSetting
import com.ss_team_1.koibitoshuuchuu.domain.repository.LastFocusSettingRepository
import kotlinx.coroutines.flow.Flow

class LastFocusSettingRepositoryImplementation(
    private val lastFocusSettingDataStore: LastFocusSettingDataStore
): LastFocusSettingRepository {
    override fun getLastFocusSetting(): Flow<LastFocusSetting> {
        return lastFocusSettingDataStore.lastFocusSettingDataFlow
    }

    override suspend fun setCharacterId(id: Int) {
        lastFocusSettingDataStore.setLastCharacterId(id)
    }

    override suspend fun setFocusTime(time: Int) {
        lastFocusSettingDataStore.setLastFocusTime(time)
    }

    override suspend fun setWork(work: String) {
        lastFocusSettingDataStore.setLastWork(work)
    }

    override suspend fun setScene(sceneId: Int) {
        lastFocusSettingDataStore.setScene(sceneId)
    }
}