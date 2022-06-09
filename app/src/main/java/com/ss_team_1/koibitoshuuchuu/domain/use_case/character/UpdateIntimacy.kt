package com.ss_team_1.koibitoshuuchuu.domain.use_case.character

import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.last

class UpdateIntimacy(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int, changeAmount: Int) {
        val newIntimacy = repository.getCharacter(id).last().intimacy + changeAmount
        repository.setIntimacy(id, newIntimacy)
    }
}