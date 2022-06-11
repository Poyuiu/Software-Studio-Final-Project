package com.ss_team_1.koibitoshuuchuu.data.data_source.user

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.util.*

private val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name="user_data")

class UserDataStore(val context: Context) {
    private val _id = longPreferencesKey("id")
    private val _userName = stringPreferencesKey("user_name")
    private val _photoUrl = stringPreferencesKey("photo_url")
    private val _gender = stringPreferencesKey("gender")
    private val _birthday = longPreferencesKey("birthday")
    private val _money = intPreferencesKey("money")
    private val _gem = intPreferencesKey("gem")
    private val _joinDate = longPreferencesKey("join_date")
    private val _lastUsedCharacterId = intPreferencesKey("last_used_character_id")

    val userDataFlow = context.userDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { user ->
            val id = user[_id] ?: 0
            val userName = user[_userName] ?: ""
            val photoUrl = user[_photoUrl] ?: ""
            val gender = user[_gender] ?: ""
            val birthday = Calendar.getInstance()
            birthday.timeInMillis = user[_birthday] ?: 0
            val joinDate = Calendar.getInstance()
            joinDate.timeInMillis = user[_joinDate] ?: 0
            val money = user[_money] ?: 0
            val gem = user[_gem] ?: 0
            val lastUsedCharacterId = user[_lastUsedCharacterId] ?: 0

            User(id, userName, photoUrl, gender, birthday, joinDate, money, gem, lastUsedCharacterId)
        }

    suspend fun saveId(newId: Long) {
        context.userDataStore.edit { user ->
            user[_id] = newId
        }
    }
    suspend fun saveUserName(newUserName: String) {
        context.userDataStore.edit { user ->
            user[_userName] = newUserName
        }
    }
    suspend fun savePhotoUrl(newUrl: String) {
        context.userDataStore.edit { user ->
            user[_photoUrl] = newUrl
        }
    }
    suspend fun saveGender(newGender: String) {
        context.userDataStore.edit { user ->
            user[_gender] = newGender
        }
    }
    suspend fun saveBirthday(newBirthday: Long) {
        context.userDataStore.edit { user ->
            user[_birthday] = newBirthday
        }
    }
    suspend fun saveJoinDate(newDate: Long) {
        context.userDataStore.edit { user ->
            user[_joinDate] = newDate
        }
    }
    suspend fun saveMoney(newMoney: Int) {
        context.userDataStore.edit { user ->
            user[_money] = newMoney
        }
    }
    suspend fun saveGem(newGem: Int) {
        context.userDataStore.edit { user ->
            user[_gem] = newGem
        }
    }
}