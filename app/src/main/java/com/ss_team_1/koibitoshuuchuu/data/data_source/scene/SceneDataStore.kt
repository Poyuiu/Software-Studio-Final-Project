package com.ss_team_1.koibitoshuuchuu.data.data_source.scene

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Scene
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.sceneDataStore: DataStore<Preferences> by preferencesDataStore(name="scene_data")
private const val numOfScenes = 3

class SceneDataStore(val context: Context) {
    private val _owned = List(numOfScenes) {
        booleanPreferencesKey("owned$it")
    }

    val sceneDataFlow = context.sceneDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { scene ->
            List(numOfScenes) {
                Scene(it, scene[_owned[it]] ?: false)
            }
        }

    fun getScene(id: Int): Flow<Scene> {
        return context.sceneDataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { scene ->
                Scene(id, scene[_owned[id]] ?: false)
            }
    }

    suspend fun setOwned(id: Int, newOwned: Boolean) {
        context.sceneDataStore.edit { scene ->
            scene[_owned[id]] = newOwned
        }
    }
}