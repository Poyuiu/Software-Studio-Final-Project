package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.CharacterDataStore
import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class CharacterRepositoryImplementation (
    private val characterDataStore: CharacterDataStore
): CharacterRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun getAllCharacter(): LiveData<List<Character>> {
        return characterDataStore.characterDataFlow.asLiveData(coroutineScope.coroutineContext)
    }

    override fun getCharacter(id: Int): LiveData<Character> {
        return characterDataStore.getCharacter(id).asLiveData(coroutineScope.coroutineContext)
    }

    override fun updateIntimacy(id: Int, changeAmount: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            val newIntimacy = characterDataStore.getCharacter(id).last().intimacy + changeAmount
            characterDataStore.setIntimacy(id, newIntimacy)
        }
    }
}