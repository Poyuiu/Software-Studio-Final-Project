package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Greeting (
    @PrimaryKey
    val id: Int,
    val character_name: String,
    val greeting: String
)