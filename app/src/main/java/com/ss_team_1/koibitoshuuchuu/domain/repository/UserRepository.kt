package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData
import com.ss_team_1.koibitoshuuchuu.domain.model.User

interface UserRepository {
    fun getUserInfo(): LiveData<User>
    fun setId(id: Long)
}