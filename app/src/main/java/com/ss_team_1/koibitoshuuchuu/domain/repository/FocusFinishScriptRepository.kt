package com.ss_team_1.koibitoshuuchuu.domain.repository

interface FocusFinishScriptRepository {
    suspend fun getAllFinishScript(name: String): List<String>
    suspend fun getRandomFinishScript(name: String): String
}