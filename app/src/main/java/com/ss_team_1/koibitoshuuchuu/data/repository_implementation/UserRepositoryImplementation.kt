package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepositoryImplementation(val context: Context): UserRepository {
    private val userDataStore: UserDataStore = UserDataStore(context)
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    override fun getUserInfo(): LiveData<User> {
        return userDataStore.userDataFlow.asLiveData()
    }
    override fun setId(id: Long) {
        coroutineScope.launch(Dispatchers.IO) {
            userDataStore.saveId(id, context)
        }
    }
}