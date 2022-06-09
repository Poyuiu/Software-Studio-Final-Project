package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacter(): Flow<List<Character>>
    fun getCharacter(id: Int): Flow<Character>
    suspend fun setIntimacy(id: Int, newIntimacy: Int)
}