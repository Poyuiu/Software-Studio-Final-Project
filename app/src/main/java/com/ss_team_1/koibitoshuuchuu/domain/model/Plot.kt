package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity

@Entity(primaryKeys = ["character_name", "level", "order"])
data class Plot (
    val character_name: String,
    val level: Int,
    val order: Int,
    val line: String
)