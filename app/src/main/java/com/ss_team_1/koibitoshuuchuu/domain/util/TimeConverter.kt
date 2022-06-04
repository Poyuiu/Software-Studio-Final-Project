package com.ss_team_1.koibitoshuuchuu.domain.util

import androidx.room.TypeConverter
import java.util.*

class TimeConverter {
        @TypeConverter
        fun longToCalendar(timeInMillis: Long): Calendar {
            var ret = Calendar.getInstance()
            ret.timeInMillis = timeInMillis
            return ret
        }

        @TypeConverter
        fun calendarToLong(calendar: Calendar): Long {
            return calendar.timeInMillis
        }

}