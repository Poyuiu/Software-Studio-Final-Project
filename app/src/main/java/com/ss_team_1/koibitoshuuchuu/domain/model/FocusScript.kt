package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FocusScript (
    @PrimaryKey
    val id: Int,
    val character_name: String,
    val script: String
)