package com.ss_team_1.koibitoshuuchuu.domain.use_case.scene

import com.ss_team_1.koibitoshuuchuu.domain.model.Scene
import com.ss_team_1.koibitoshuuchuu.domain.repository.SceneRepository
import kotlinx.coroutines.flow.Flow

class GetAllScene(
    private val repository: SceneRepository
) {
    operator fun invoke(): Flow<List<Scene>> {
        return repository.getAllScene()
    }
}