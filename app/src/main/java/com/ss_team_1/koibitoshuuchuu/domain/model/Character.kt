package com.ss_team_1.koibitoshuuchuu.domain.model

data class Character(
    val id: Int,
    val level: Int,
    val intimacy: Int
) {
    fun intimacyNeeded(): Int = (level+1)*100
}