package com.ss_team_1.koibitoshuuchuu.domain.repository

import androidx.lifecycle.LiveData

interface SceneRepository {
    fun isOwned(id: Int): LiveData<Boolean>
    fun setSceneIsOwned(id: Int, newValue: Boolean)
}