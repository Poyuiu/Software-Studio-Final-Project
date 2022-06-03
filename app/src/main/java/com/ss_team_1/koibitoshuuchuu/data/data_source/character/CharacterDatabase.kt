package com.ss_team_1.koibitoshuuchuu.data.data_source.character

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ss_team_1.koibitoshuuchuu.domain.model.Character

@Database(entities = [Character::class], version = 1)
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: CharacterDatabase ?= null
        fun getDatabase(context: Context): CharacterDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    CharacterDatabase::class.java,
                    "character_database")
                    .createFromAsset("database/character_database.db")
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}