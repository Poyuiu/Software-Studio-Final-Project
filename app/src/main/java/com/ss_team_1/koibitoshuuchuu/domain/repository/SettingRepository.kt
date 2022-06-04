package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.Setting

interface SettingRepository {
    fun getSetting(): LiveData<Setting>
    fun setVolume(newVolume: Int)
    // more updates ...
}