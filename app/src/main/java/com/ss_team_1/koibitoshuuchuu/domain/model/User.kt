package com.ss_team_1.koibitoshuuchuu.domain.model

import java.util.*

data class User (
    val id: Long,
    val user_name: String,
    val photo_url: String,
    val gender: String,
    val birthday: Calendar,
    val join_date: Calendar,
    val money: Int,
    val gem: Int,
    val lastUsedCharacterId: Int,
)