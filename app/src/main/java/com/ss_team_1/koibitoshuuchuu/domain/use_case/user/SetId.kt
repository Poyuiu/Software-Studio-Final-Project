package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository

class SetId(
    private val repository: UserRepository
) {
    suspend operator fun invoke(newId: Long) {
        return repository.setId(newId)
    }
}