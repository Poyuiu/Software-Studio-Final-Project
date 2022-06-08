package com.ss_team_1.koibitoshuuchuu.presentation

import android.app.Application
import android.content.Context
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.CharacterDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory.FocusHistoryDatabase
import com.ss_team_1.koibitoshuuchuu.data.data_source.item.ItemDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.plot.PlotDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.scene.SceneDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.setting.SettingDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDataStore
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.*

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
    private val itemLocalDataSource = ItemDataStore(context)
    val itemRepository = ItemRepositoryImplementation(itemLocalDataSource)
    private val plotLocalDataSource = PlotDataStore(context)
    val plotRepository = PlotRepositoryImplementation(plotLocalDataSource)
    private val sceneLocalDataSource = SceneDataStore(context)
    val sceneRepository = SceneRepositoryImplementation(sceneLocalDataSource)
    private val settingLocalDataSource = SettingDataStore(context)
    val settingRepository = SettingRepositoryImplementation(settingLocalDataSource)
    private val userLocalDataSource = UserDataStore(context)
    val userRepository = UserRepositoryImplementation(userLocalDataSource)
}