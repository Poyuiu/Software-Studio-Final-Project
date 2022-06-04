package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class FocusHistory (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,
    @NonNull
    val characterId: Int,
    @NonNull
    val startTime: Calendar,
    @NonNull
    val endTime: Calendar,
)