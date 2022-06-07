package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.Setting

interface SettingRepository {
    fun getSetting(): LiveData<Setting>
    fun setSoundEffectVolume(newVolume: Int)
    fun setBGMVolume(newVolume: Int)
    fun setKeepScreenOpen(newValue: Boolean)
    fun setLanguage(newLanguage: Int)
    fun setRestrictedMode(newValue: Boolean)
}