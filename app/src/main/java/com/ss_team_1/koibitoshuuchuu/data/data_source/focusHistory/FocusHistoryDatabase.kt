package com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory

@Database(entities = [FocusHistory::class], version = 1)
abstract class FocusHistoryDatabase: RoomDatabase() {
    abstract fun focusHistoryDao(): FocusHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: FocusHistoryDatabase ?= null
        fun getDatabase(context: Context): FocusHistoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    FocusHistoryDatabase::class.java,
                    "focus_history_database")
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}