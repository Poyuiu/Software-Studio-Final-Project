package com.ss_team_1.koibitoshuuchuu.data.data_source.setting

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Setting
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.settingDataStore: DataStore<Preferences> by preferencesDataStore(name="setting_data")

@Singleton
class SettingDataStore @Inject constructor(@ApplicationContext context: Context) {
    private val _soundEffectVolume = intPreferencesKey("sound_effect_volume")
    private val _bgmVolume = intPreferencesKey("BGM_volume")
    private val _keepScreenOpen = booleanPreferencesKey("keep_screen_open")
    private val _language = intPreferencesKey("language")
    private val _restrictedMode = booleanPreferencesKey("restriction_mode")

    private val settingDataStore = context.settingDataStore

    val settingDataFlow = settingDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { setting ->
            val soundEffectVolume = setting[_soundEffectVolume] ?: 50
            val bgmVolume = setting[_bgmVolume] ?: 50
            val keepScreenOpen = setting[_keepScreenOpen] ?: true
            val language = setting[_language] ?: 0
            val restrictedMode = setting[_restrictedMode] ?: false

            Setting(soundEffectVolume, bgmVolume, keepScreenOpen, language, restrictedMode)
        }

    suspend fun saveSoundEffectVolume (newVolume: Int) {
        settingDataStore.edit { setting ->
            setting[_soundEffectVolume] = newVolume
        }
    }
    suspend fun saveBGMVolume (newVolume: Int) {
        settingDataStore.edit { setting ->
            setting[_bgmVolume] = newVolume
        }
    }
    suspend fun saveKeepScreenOpen (newValue: Boolean) {
        settingDataStore.edit { setting ->
            setting[_keepScreenOpen] = newValue
        }
    }
    suspend fun saveLanguage (newLanguage: Int) {
        settingDataStore.edit { setting ->
            setting[_language] = newLanguage
        }
    }
    suspend fun saveRestrictedMode (newValue: Boolean) {
        settingDataStore.edit { setting ->
            setting[_restrictedMode] = newValue
        }
    }
}