package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

//0: 四季映姬, 1: 魂魄妖夢, 2: 吉吊八千代
data class Character(
    val id: Int,
    val intimacy: Int
)