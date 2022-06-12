package com.ss_team_1.koibitoshuuchuu.domain.use_case.user

import com.ss_team_1.koibitoshuuchuu.domain.repository.UserRepository
import kotlinx.coroutines.flow.first

class UpdateMoney(
    private val repository: UserRepository
) {
    suspend operator fun invoke(changeAmount: Int) {
        val newValue = changeAmount + repository.getUserInfo().first().money
        return repository.setMoney(newValue)
    }
}