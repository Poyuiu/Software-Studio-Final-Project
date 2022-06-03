package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey
    @NonNull
    val id: Int,
    @NonNull
    val quantity_owned: Int
)