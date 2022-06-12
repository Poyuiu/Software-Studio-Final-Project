package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.model.User
import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserInfo(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<User> {
        return repository.getUserInfo()
    }
}