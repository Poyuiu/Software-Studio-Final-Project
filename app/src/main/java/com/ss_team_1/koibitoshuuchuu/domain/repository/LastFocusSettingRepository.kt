package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.LastFocusSetting
import kotlinx.coroutines.flow.Flow

interface LastFocusSettingRepository {
    fun getLastFocusSetting(): Flow<LastFocusSetting>
    suspend fun setCharacterId(id: Int)
    suspend fun setFocusTime(time: Int)
    suspend fun setWork(work: String)
    suspend fun setScene(sceneId: Int)
}