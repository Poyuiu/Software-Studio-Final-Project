package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.Character

interface CharacterRepository {
    fun getAllCharacter(): MutableLiveData<List<Character>>
    fun getCharacter(name: String): LiveData<Character>
    fun increaseIntimacy(name: String, amount: Int)
}