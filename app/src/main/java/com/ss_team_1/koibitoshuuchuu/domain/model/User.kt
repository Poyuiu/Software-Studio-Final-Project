package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User (
    @PrimaryKey
    val id: Long,
    val user_name: String,
    val photo_url: Int,
    val gender: String,
    val birthday: Date,
    val money: Int,
    val gem: Int,
    val join_date: Date,
    @Ignore // fetch from focus history
    val total_focus_time: Long,
)