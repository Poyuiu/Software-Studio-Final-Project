package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import java.util.*

interface UserRepository {
    fun getUserInfo(): LiveData<User>
    fun setId(newId: Long)
    fun setUserName(newName: String)
    fun setPhotoUrl(newUrl: String)
    fun setGender(newGender: String)
    fun setBirthday(newBirthday: Calendar)
    fun setJoinDate(newDate: Calendar)
    fun updateMoney(changeAmount: Int)
    fun updateGem(changeAmount: Int)
}