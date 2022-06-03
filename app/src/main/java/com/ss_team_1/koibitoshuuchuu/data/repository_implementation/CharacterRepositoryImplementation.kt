package com.ss_team_1.koibitoshuuchuu.data.repository_implementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.CharacterDao
import com.ss_team_1.koibitoshuuchuu.domain.model.Character
import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterRepositoryImplementation (
    private val dao: CharacterDao
): CharacterRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val allCharacter = MutableLiveData<List<Character>>()

    override fun getAllCharacter(): MutableLiveData<List<Character>> {
        coroutineScope.launch(Dispatchers.IO) {
            dao.getAllCharacter()
        }
        return allCharacter
    }

    override fun getCharacter(name: String): LiveData<Character> {
        TODO("Not yet implemented")
    }

    override fun increaseIntimacy(name: String, amount: Int) {
        TODO("Not yet implemented")
    }
}