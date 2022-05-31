package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity

@Entity
data class Scene (
    val name: String,
    val picture_url: String,
    val price: Int,
    val is_owned: Boolean
)