package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository
import java.util.*

class SetBirthday(
    private val repository: UserRepository
) {
    suspend operator fun invoke(newBirthday: Calendar) {
        return repository.setBirthday(newBirthday)
    }
}