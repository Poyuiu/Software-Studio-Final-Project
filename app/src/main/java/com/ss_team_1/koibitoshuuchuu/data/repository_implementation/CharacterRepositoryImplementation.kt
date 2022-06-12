package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import com.ss_team_1.koibitoshuuchuu.data.data_source.character.CharacterDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImplementation (
    private val characterDataStore: CharacterDataStore
): CharacterRepository {
    override fun getAllCharacter(): Flow<List<Character>> {
        return characterDataStore.characterDataFlow
    }

    override fun getCharacter(id: Int): Flow<Character> {
        return characterDataStore.getCharacter(id)
    }

    override suspend fun setIntimacy(id: Int, newIntimacy: Int) {
        characterDataStore.setIntimacy(id, newIntimacy)
    }

    override suspend fun setLevel(id: Int, newLevel: Int) {
        characterDataStore.setLevel(id, newLevel)
    }
}