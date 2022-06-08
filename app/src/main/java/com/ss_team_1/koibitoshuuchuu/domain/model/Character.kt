package com.ss_team_1.koibitoshuuchuu.domain.model

data class Character(
    val id: Int,
    val intimacy: Int
) {
    fun level(): Int {
        var intimacy_needed = 0
        var level = -1
        while (intimacy >= intimacy_needed) {
            level++
            intimacy_needed = ((level + 2) * (level + 1)) / 2 * 100
        }
        return level
    }

    fun intimacy_needed(): Int {
        var intimacy_needed = 0
        var level = -1
        while (intimacy >= intimacy_needed) {
            level++
            intimacy_needed = ((level + 2) * (level + 1)) / 2 * 100
        }
        return intimacy_needed - intimacy
    }
}