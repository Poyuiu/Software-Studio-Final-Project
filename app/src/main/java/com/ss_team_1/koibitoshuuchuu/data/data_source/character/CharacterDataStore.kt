package com.ss_team_1.koibitoshuuchuu.data.data_source.character

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.characterDataStore: DataStore<Preferences> by preferencesDataStore(name="character_data")
const val numOfCharacters = 3

class CharacterDataStore(val context: Context) {
    private val _intimacy = List(numOfCharacters) {
        intPreferencesKey("intimacy$it")
    }

    val characterDataFlow = context.characterDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { character ->
            List(numOfCharacters) {
                Character(it, character[_intimacy[it]] ?: 0)
            }
        }

    fun getCharacter(id: Int): Flow<Character> {
        return context.characterDataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { character ->
                Character(id, character[_intimacy[id]] ?: 0)
            }
    }

    suspend fun setIntimacy(id: Int, newIntimacy: Int) {
        context.characterDataStore.edit { character ->
            character[_intimacy[id]] =  newIntimacy
        }
    }
}