package com.ss_team_1.koibitoshuuchuu.data.data_source.user

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

private val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name="user_data")

@Singleton
class UserDataStore @Inject constructor(@ApplicationContext context: Context) {
    private val _id = longPreferencesKey("id")
    private val _userName = stringPreferencesKey("user_name")
    private val _photoUrl = stringPreferencesKey("photo_url")
    private val _gender = stringPreferencesKey("gender")
    private val _birthday = longPreferencesKey("birthday")
    private val _money = intPreferencesKey("money")
    private val _gem = intPreferencesKey("gem")
    private val _joinDate = longPreferencesKey("join_date")
    private val _lastUsedCharacterId = intPreferencesKey("last_used_character_id")

    private val userDataStore = context.userDataStore

    val userDataFlow = userDataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { user ->
            val id = user[_id] ?: 1234567
            val userName = user[_userName] ?: "酷酷的名字"
            val photoUrl = user[_photoUrl] ?: ""
            val gender = user[_gender] ?: "酷酷的草履蟲"
            val birthday = Calendar.getInstance()
            birthday.timeInMillis = user[_birthday] ?: Calendar.getInstance().timeInMillis
            val joinDate = Calendar.getInstance()
             joinDate.timeInMillis = user[_joinDate] ?: 0
            val money = user[_money] ?: 0
            val gem = user[_gem] ?: 0
            val lastUsedCharacterId = user[_lastUsedCharacterId] ?: 0

            User(id, userName, photoUrl, gender, birthday, joinDate, money, gem, lastUsedCharacterId)
        }

    suspend fun saveId(newId: Long) {
        userDataStore.edit { user ->
            user[_id] = newId
        }
    }
    suspend fun saveUserName(newUserName: String) {
        userDataStore.edit { user ->
            user[_userName] = newUserName
        }
    }
    suspend fun savePhotoUrl(newUrl: String) {
        userDataStore.edit { user ->
            user[_photoUrl] = newUrl
        }
    }
    suspend fun saveGender(newGender: String) {
        userDataStore.edit { user ->
            user[_gender] = newGender
        }
    }
    suspend fun saveBirthday(newBirthday: Long) {
        userDataStore.edit { user ->
            user[_birthday] = newBirthday
        }
    }
    suspend fun saveJoinDate(newDate: Long) {
        userDataStore.edit { user ->
            user[_joinDate] = newDate
        }
    }
    suspend fun saveMoney(newMoney: Int) {
        userDataStore.edit { user ->
            user[_money] = newMoney
        }
    }
    suspend fun saveGem(newGem: Int) {
        userDataStore.edit { user ->
            user[_gem] = newGem
        }
    }
    suspend fun saveLastUsedCharacterId(id: Int) {
        userDataStore.edit { user ->
            user[_lastUsedCharacterId] = id
        }
    }
}