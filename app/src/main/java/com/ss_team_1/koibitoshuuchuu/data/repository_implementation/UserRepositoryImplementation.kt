package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class UserRepositoryImplementation(
    private val userDataStore: UserDataStore
): UserRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun getUserInfo(): LiveData<User> {
        return userDataStore.userDataFlow.asLiveData(coroutineScope.coroutineContext)
    }

    override fun setId(newId: Long) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataStore.saveId(newId)
        }
    }

    override fun setUserName(newName: String) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataStore.saveUserName(newName)
        }
    }

    override fun setPhotoUrl(newUrl: String) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataStore.savePhotoUrl(newUrl)
        }
    }

    override fun setGender(newGender: String) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataStore.saveGender(newGender)
        }
    }

    override fun setBirthday(newBirthday: Calendar) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataStore.saveBirthday(newBirthday.timeInMillis)
        }
    }

    override fun setJoinDate(newDate: Calendar) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataStore.saveJoinDate(newDate.timeInMillis)
        }
    }

    override fun updateMoney(changeAmount: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            val newMoney = userDataStore.userDataFlow.last().money + changeAmount
            userDataStore.saveMoney(newMoney)
        }
    }

    override fun updateGem(changeAmount: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            val newGem = userDataStore.userDataFlow.last().gem
            userDataStore.saveGem(newGem)
        }
    }
}