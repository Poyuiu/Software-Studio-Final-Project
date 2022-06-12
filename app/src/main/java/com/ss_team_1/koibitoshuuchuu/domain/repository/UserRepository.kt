package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.util.*

interface UserRepository {
    fun getUserInfo(): Flow<User>
    suspend fun setId(newId: Long)
    suspend fun setUserName(newName: String)
    suspend fun setPhotoUrl(newUrl: String)
    suspend fun setGender(newGender: String)
    suspend fun setBirthday(newBirthday: Calendar)
    suspend fun setJoinDate(newDate: Calendar)
    suspend fun setMoney(newMoney: Int)
    suspend fun setGem(newGem: Int)
    suspend fun setLastUsedCharacterId(id: Int)
}