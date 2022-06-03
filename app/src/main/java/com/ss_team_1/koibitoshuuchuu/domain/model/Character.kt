package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(
    @PrimaryKey
    val name: String,
    val picture_url: String,
    val intimacy: Int,
    val intimacy_level: Int,
    val level_intimacy_need: Int,
    val nickname: String,
    val height: Float,
    val species: String,
    val residence: String,
    val profession: String,
    val introduction: String
)