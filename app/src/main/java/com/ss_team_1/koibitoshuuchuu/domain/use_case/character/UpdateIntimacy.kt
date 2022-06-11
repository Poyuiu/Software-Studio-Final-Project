package com.ss_team_1.koibitoshuuchuu.domain.use_case.character

import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.first

class UpdateIntimacy(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int, changeAmount: Int) {
        val character = repository.getCharacter(id).first()
        var newLevel = character.level
        var newIntimacy = character.intimacy + changeAmount
        while (newIntimacy >= (newLevel+1)*100) {
            newIntimacy -= (newLevel+1)*100
            newLevel++
        }
        while (newIntimacy < 0) {
            newIntimacy += newLevel*100
            newLevel--
        }
        repository.setIntimacy(id, newIntimacy)
        repository.setLevel(id, newLevel)
    }
}