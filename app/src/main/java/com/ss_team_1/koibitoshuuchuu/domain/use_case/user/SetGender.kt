package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository

class SetGender(
    private val repository: UserRepository
) {
    suspend operator fun invoke(newGender: String) {
        return repository.setGender(newGender)
    }
}