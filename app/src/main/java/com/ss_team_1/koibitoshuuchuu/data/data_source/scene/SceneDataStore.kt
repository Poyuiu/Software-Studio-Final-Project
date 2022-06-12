package com.ss_team_1.koibitoshuuchuu.data.data_source.scene

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Scene
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.sceneDataStore: DataStore<Preferences> by preferencesDataStore(name="scene_data")
const val numOfScenes = 3

@Singleton
class SceneDataStore @Inject constructor(@ApplicationContext context: Context) {
    private val _owned = List(numOfScenes) {
        booleanPreferencesKey("owned$it")
    }

    private val sceneDataStore = context.sceneDataStore

    val sceneDataFlow = sceneDataStore.data
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

    suspend fun setOwned(id: Int, newOwned: Boolean) {
        sceneDataStore.edit { scene ->
            scene[_owned[id]] = newOwned
        }
    }
}