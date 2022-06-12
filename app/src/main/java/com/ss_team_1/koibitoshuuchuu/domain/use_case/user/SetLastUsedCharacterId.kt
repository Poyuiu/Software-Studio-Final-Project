package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository

class SetLastUsedCharacterId(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: Int) {
        return repository.setLastUsedCharacterId(id)
    }
}