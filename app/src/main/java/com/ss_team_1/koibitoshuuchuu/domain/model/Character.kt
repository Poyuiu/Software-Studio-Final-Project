package com.ss_team_1.koibitoshuuchuu.domain.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Character(
    @PrimaryKey
    @NonNull
    var name: String,
    @NonNull
    var intimacy: Int,

    // fixed
    @Ignore
    val picture_url: String,
    @Ignore
    val intimacy_level: Int,
    @Ignore
    val nickname: String,
    @Ignore
    val height: Float,
    @Ignore
    val species: String,
    @Ignore
    val residence: String,
    @Ignore
    val profession: String,
    @Ignore
    val introduction: String
) {
    constructor(name: String, intimacy: Int): this(name, intimacy, "", 0, "", 0f, "", "", "", "")
}