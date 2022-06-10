package com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory

import android.content.Context
import androidx.room.*
import com.ss_team_1.koibitoshuuchuu.domain.model.FocusHistory
import com.ss_team_1.koibitoshuuchuu.domain.util.TimeConverter

@Database(entities = [FocusHistory::class], version = 1)
@TypeConverters(TimeConverter::class)
abstract class FocusHistoryDatabase: RoomDatabase() {
    abstract val focusHistoryDao: FocusHistoryDao

    companion object {
        const val DATABASE_NAME = "focus_history_database"
    }
}