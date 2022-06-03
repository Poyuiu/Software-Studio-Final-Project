package com.ss_team_1.koibitoshuuchuu.data.data_source.character

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.ss_team_1.koibitoshuuchuu.domain.model.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM Character WHERE name=:name")
    fun getCharacter(name: String): LiveData<Character>

    @Query("SELECT * FROM Character")
    fun getAllCharacter(): LiveData<List<Character>>

    @Query("UPDATE Character SET intimacy=intimacy+:quantity WHERE name=:name")
    fun updateIntimacy(name: String, quantity: Int)

}