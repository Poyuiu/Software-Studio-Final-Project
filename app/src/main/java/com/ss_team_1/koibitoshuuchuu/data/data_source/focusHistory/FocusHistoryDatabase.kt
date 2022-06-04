package com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory

import android.content.Context
import androidx.room.*
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import com.ss_team_1.koibitoshuuchuu.domain.util.TimeConverter

@Database(entities = [FocusHistory::class], version = 1)
@TypeConverters(TimeConverter::class)
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