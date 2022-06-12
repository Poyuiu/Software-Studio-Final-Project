package com.ss_team_1.koibitoshuuchuu.presentation.state

import com.ss_team_1.koibitoshuuchuu.domain.model.User
import java.util.*

data class UserState (
    val userInfo: User = User(0, "", "", "", Calendar.getInstance(), Calendar.getInstance() ,0, 0, 0)
)