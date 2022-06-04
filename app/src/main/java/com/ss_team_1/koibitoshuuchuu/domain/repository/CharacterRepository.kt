package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.Character

interface CharacterRepository {
    fun getAllCharacter(): LiveData<List<Character>>
    fun getCharacter(id: Int): LiveData<Character>
    fun updateIntimacy(id: Int, amount: Int)
}