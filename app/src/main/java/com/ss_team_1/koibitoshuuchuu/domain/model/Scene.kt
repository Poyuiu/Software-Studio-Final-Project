package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Scene (
    @PrimaryKey
    @NonNull
    val id: Int,
    @NonNull
    val is_owned: Boolean
)