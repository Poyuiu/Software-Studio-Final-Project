package com.ss_team_1.koibitoshuuchuu.domain.repository

import com.ss_team_1.koibitoshuuchuu.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacter(name: String): Character
    suspend fun increaseIntimacy(name: String, amount: Int)
}