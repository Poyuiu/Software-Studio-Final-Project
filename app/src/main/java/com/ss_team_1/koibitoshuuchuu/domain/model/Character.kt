package com.ss_team_1.koibitoshuuchuu.domain.model

data class Character(
    val id: Int,
    val intimacy: Int
) {
    fun level(): Int {
        var intimacyNeeded = 0
        var level = -1
        while (intimacy >= intimacyNeeded) {
            level++
            intimacyNeeded = ((level + 2) * (level + 1)) / 2 * 100
        }
        return level
    }

    fun intimacyNeeded(): Int {
        var intimacyNeeded = 0
        var level = -1
        while (intimacy >= intimacyNeeded) {
            level++
            intimacyNeeded = ((level + 2) * (level + 1)) / 2 * 100
        }
        return intimacyNeeded - intimacy
    }
}