package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import java.util.*

class UserRepositoryImplementation(
    private val userDataStore: UserDataStore
): UserRepository {
    override fun getUserInfo(): Flow<User> {
        return userDataStore.userDataFlow
    }

    override suspend fun setId(newId: Long) {
        userDataStore.saveId(newId)
    }

    override suspend fun setUserName(newName: String) {
        userDataStore.saveUserName(newName)
    }

    override suspend fun setPhotoUrl(newUrl: String) {
        userDataStore.savePhotoUrl(newUrl)
    }

    override suspend fun setGender(newGender: String) {
        userDataStore.saveGender(newGender)
    }

    override suspend fun setBirthday(newBirthday: Calendar) {
        userDataStore.saveBirthday(newBirthday.timeInMillis)
    }

    override suspend fun setJoinDate(newDate: Calendar) {
        userDataStore.saveJoinDate(newDate.timeInMillis)
    }

    override suspend fun setMoney(newMoney: Int) {
        userDataStore.saveMoney(newMoney)
    }

    override suspend fun setGem(newGem: Int) {
        userDataStore.saveGem(newGem)
    }

    override suspend fun setLastUsedCharacterId(id: Int) {
        userDataStore.saveLastUsedCharacterId(id)
    }
}