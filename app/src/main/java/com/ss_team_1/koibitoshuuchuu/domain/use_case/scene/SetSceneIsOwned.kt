package com.ss_team_1.koibitoshuuchuu.domain.use_case.scene

import com.ss_team_1.koibitoshuuchuu.domain.repository.SceneRepository

class SetSceneIsOwned(
    private val repository: SceneRepository
) {
    suspend operator fun invoke(id: Int, newValue: Boolean) {
        repository.setSceneIsOwned(id, newValue)
    }
}