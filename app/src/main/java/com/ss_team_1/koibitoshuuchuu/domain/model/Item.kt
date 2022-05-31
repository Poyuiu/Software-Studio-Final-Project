package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey
    val name: String,
    val image_url: String,
    val price: Int,
    val quantity_owned: Int
)