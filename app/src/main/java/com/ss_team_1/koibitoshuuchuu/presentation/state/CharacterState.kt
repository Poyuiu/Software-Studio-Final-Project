package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.data.data_source.character.numOfCharacters
import com.ss_team_1.koibitoshuuchuu.domain.model.Character

data class CharacterState (
    val characters: List<Character> = List(numOfCharacters) {
        Character(it, 0)
    }
)