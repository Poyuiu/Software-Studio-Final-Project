package com.ss_team_1.koibitoshuuchuu.presentation

import android.app.Application
import android.content.Context
import com.ss_team_1.koibitoshuuchuu.data.data_source.item.ItemDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.plot.PlotStateDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.scene.SceneDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.setting.SettingDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDataStore
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.*
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
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
   private val sceneLocalDataSource = SceneDataStore(context)
    val sceneRepository = SceneRepositoryImplementation(sceneLocalDataSource)
    private val settingLocalDataSource = SettingDataStore(context)
    val settingRepository = SettingRepositoryImplementation(settingLocalDataSource)
    private val userLocalDataSource = UserDataStore(context)
    val userRepository = UserRepositoryImplementation(userLocalDataSource)
}