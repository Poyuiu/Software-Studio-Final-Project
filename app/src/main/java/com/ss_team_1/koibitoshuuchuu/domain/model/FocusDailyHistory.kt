package com.ss_team_1.koibitoshuuchuu.domain.model

import java.util.*

data class FocusDailyHistory(
    val characterId: Int,
    val date: Calendar,
    val totalTime: Float // time in hours
)
