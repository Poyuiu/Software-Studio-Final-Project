package com.ss_team_1.koibitoshuuchuu.data.data_source.lastFocusSetting

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.numOfCharacters
import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import com.ss_team_1.koibitoshuuchuu.domain.model.LastFocusSetting
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


private val Context.lastFocusSettingDataStore: DataStore<Preferences> by preferencesDataStore(name = "last_focus_setting_data")

@Singleton
class LastFocusSettingDataStore @Inject constructor(@ApplicationContext context: Context) {
    private val _focusTime = intPreferencesKey("focus_time")
    private val _work = stringPreferencesKey("word")
    private val _sceneId = intPreferencesKey("scene_id")

    private val lastFocusSettingDataStore = context.lastFocusSettingDataStore

    val lastFocusSettingDataFlow = lastFocusSettingDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map {
            LastFocusSetting(it[_focusTime]?:0, it[_work]?:"", it[_sceneId]?:0)
        }

    suspend fun setLastFocusTime(time: Int) {
        lastFocusSettingDataStore.edit {
            it[_focusTime] = time
        }
    }

    suspend fun setLastWork(work: String) {
        lastFocusSettingDataStore.edit {
            it[_work] = work
        }
    }

    suspend fun setScene(scene: Int) {
        lastFocusSettingDataStore.edit {
            it[_sceneId] = scene
        }
    }
}