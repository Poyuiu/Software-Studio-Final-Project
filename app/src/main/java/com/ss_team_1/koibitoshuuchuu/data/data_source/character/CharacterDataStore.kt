package com.ss_team_1.koibitoshuuchuu.data.data_source.character

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.characterDataStore: DataStore<Preferences> by preferencesDataStore(name="character_data")
const val numOfCharacters = 3

@Singleton
class CharacterDataStore @Inject constructor(@ApplicationContext context: Context) {
    private val _intimacy = List(numOfCharacters) {
        intPreferencesKey("intimacy$it")
    }
    private val _level = List(numOfCharacters) {
        intPreferencesKey("level$it")
    }

    private val characterDataStore = context.characterDataStore

    val characterDataFlow = characterDataStore.data
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
                if (it == 0)
                    Character(it, character[_level[it]] ?: 1, character[_intimacy[it]] ?: 0)
                else
                    Character(it, character[_level[it]] ?: 0, character[_intimacy[it]] ?: 0)
            }
        }

    fun getCharacter(id: Int): Flow<Character> =
        characterDataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }
            .map { character ->
                if (id == 0)
                    Character(id, character[_level[id]] ?: 1, character[_intimacy[id]] ?: 0)
                else
                    Character(id, character[_level[id]] ?: 0, character[_intimacy[id]] ?: 0)
            }

    suspend fun setIntimacy(id: Int, newIntimacy: Int) {
        characterDataStore.edit { character ->
            character[_intimacy[id]] =  newIntimacy
        }
    }

    suspend fun setLevel(id: Int, newLevel: Int) {
        characterDataStore.edit { character ->
            character[_level[id]] = newLevel
        }
    }
}