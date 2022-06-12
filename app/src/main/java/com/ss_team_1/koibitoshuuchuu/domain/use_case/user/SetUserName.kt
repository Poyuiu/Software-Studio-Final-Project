package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository

class SetUserName(
    private val repository: UserRepository
) {
    suspend operator fun invoke(newName: String) {
        return repository.setUserName(newName)
    }
}