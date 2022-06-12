package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository

class SetPhotoUrl(
    private val repository: UserRepository
) {
    suspend operator fun invoke(newPhotoUrl: String) {
        return repository.setPhotoUrl(newPhotoUrl)
    }
}