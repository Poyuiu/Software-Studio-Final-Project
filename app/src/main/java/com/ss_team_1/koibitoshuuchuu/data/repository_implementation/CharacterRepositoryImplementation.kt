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

    override fun getAllCharacter(): LiveData<List<Character>> {
        return dao.getAllCharacter()
    }

    override fun getCharacter(id: Int): LiveData<Character> {
        return dao.getCharacter(id)
    }

    override fun updateIntimacy(id: Int, quantity: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            dao.updateIntimacy(id, quantity)
        }
    }
}