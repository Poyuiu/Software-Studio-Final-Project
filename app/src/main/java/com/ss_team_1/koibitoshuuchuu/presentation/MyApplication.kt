package com.ss_team_1.koibitoshuuchuu.presentation

import android.app.Application
import android.content.Context
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.CharacterDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory.FocusHistoryDatabase
import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDataStore
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.CharacterRepositoryImplementation
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.FocusHistoryRepositoryImplementation
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.UserRepositoryImplementation
import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository

class MyApplication: Application() {
    companion object {
        var app_container: AppContainer? = null
        fun appContainer() = app_container!!
    }

    override fun onCreate() {
        super.onCreate()
        app_container = AppContainer(this)
    }
}

class AppContainer (context: Context) {
    private val characterLocalDataSource = CharacterDataStore(context)
    val characterRepository = CharacterRepositoryImplementation(characterLocalDataSource)
    private val  focusHistoryLocalDataSource = FocusHistoryDatabase.getDatabase(context)
    val focusHistoryRepository = FocusHistoryRepositoryImplementation(focusHistoryLocalDataSource)

    private val userLocalDataSource = UserDataStore(context)
    val userRepository = UserRepositoryImplementation(userLocalDataSource)
}