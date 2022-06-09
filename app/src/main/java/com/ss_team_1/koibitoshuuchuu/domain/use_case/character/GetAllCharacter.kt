package com.ss_team_1.koibitoshuuchuu.domain.use_case.character

import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharacter(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<List<Character>> {
        return repository.getAllCharacter()
    }
}