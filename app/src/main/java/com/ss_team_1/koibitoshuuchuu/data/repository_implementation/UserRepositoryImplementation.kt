package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDao
import com.ss_team_1.koibitoshuuchuu.domain.model.User
import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository

class UserRepositoryImplementation(
    private val dao: UserDao
): UserRepository {
    override fun getUserInfo(): LiveData<User> {
        TODO("Not yet implemented")
    }
}