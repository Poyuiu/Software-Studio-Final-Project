package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class FocusHistory (
    @PrimaryKey
    val date: Date,
    val character: Character,
    val duration: Long // in seconds
)