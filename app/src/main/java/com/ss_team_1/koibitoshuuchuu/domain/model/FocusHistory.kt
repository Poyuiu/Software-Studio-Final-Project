package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.MonthDay
import java.util.*

@Entity
data class FocusHistory (
    @PrimaryKey
    @NonNull
    val id: Int,
    @NonNull
    val startTime: Calendar,
    @NonNull
    val endTime: Calendar,
    @NonNull
    val characterId: Int,
)