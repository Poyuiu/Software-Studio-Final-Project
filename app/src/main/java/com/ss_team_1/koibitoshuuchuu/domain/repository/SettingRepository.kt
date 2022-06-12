package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.Setting
import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getSetting(): Flow<Setting>
    suspend fun setSoundEffectVolume(newVolume: Int)
    suspend fun setBGMVolume(newVolume: Int)
    suspend fun setKeepScreenOpen(newValue: Boolean)
    suspend fun setLanguage(newLanguage: Int)
    suspend fun setRestrictedMode(newValue: Boolean)
}