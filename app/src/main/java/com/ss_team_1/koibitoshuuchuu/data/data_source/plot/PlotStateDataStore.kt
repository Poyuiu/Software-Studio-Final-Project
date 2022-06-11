package com.ss_team_1.koibitoshuuchuu.data.data_source.plot

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.numOfCharacters
import com.ss_team_1.koibitoshuuchuu.domain.model.PlotState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.plotStateDataStore: DataStore<Preferences> by preferencesDataStore(name = "plot_state_data")
const val maxNumOfPlot = 5

class PlotStateDataStore(val context: Context) {
    private val _seen = List(numOfCharacters) { characterId ->
        List(maxNumOfPlot) { plotId ->
            booleanPreferencesKey("seen$characterId$plotId")
        }
    }

    val plotStateDataFlow = context.plotStateDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { plot ->
            List(numOfCharacters) { characterId ->
                List(maxNumOfPlot) { plotId ->
                    PlotState(characterId, plotId, plot[_seen[characterId][plotId]] ?: false)
                }
            }
        }

    suspend fun setSeen(characterId: Int, plotNum: Int, newValue: Boolean) {
        context.plotStateDataStore.edit { plot ->
            plot[_seen[characterId][plotNum]] = newValue
        }
    }
}