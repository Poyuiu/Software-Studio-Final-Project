package com.ss_team_1.koibitoshuuchuu.di

import android.app.Application
import androidx.room.Room
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.CharacterDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory.FocusHistoryDatabase
import com.ss_team_1.koibitoshuuchuu.data.data_source.item.ItemDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.lastFocusSetting.LastFocusSettingDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.plot.PlotStateDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.scene.SceneDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.setting.SettingDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.user.UserDataStore
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.*
import com.ss_team_1.koibitoshuuchuu.domain.repository.*
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.CharacterUseCases
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.GetAllCharacter
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.GetCharacterById
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.UpdateIntimacy
import com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory.*
import com.ss_team_1.koibitoshuuchuu.domain.use_case.item.GetAllItem
import com.ss_team_1.koibitoshuuchuu.domain.use_case.item.GetItemById
import com.ss_team_1.koibitoshuuchuu.domain.use_case.item.ItemUseCases
import com.ss_team_1.koibitoshuuchuu.domain.use_case.item.UpdateItemOwnedQuantity
import com.ss_team_1.koibitoshuuchuu.domain.use_case.lastFocusSettingUseCases.*
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState.GetPlotState
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState.PlotStateUseCases
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState.SetPlotState
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plotState.SetPlotStateValue
import com.ss_team_1.koibitoshuuchuu.domain.use_case.scene.GetAllScene
import com.ss_team_1.koibitoshuuchuu.domain.use_case.scene.SceneUseCases
import com.ss_team_1.koibitoshuuchuu.domain.use_case.scene.SetSceneIsOwned
import com.ss_team_1.koibitoshuuchuu.domain.use_case.setting.*
import com.ss_team_1.koibitoshuuchuu.domain.use_case.user.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(dataStore: CharacterDataStore): CharacterRepository {
        return CharacterRepositoryImplementation(dataStore)
    }

    @Provides
    @Singleton
    fun provideCharacterUseCases(repository: CharacterRepository): CharacterUseCases {
        return CharacterUseCases(
            getAllCharacter = GetAllCharacter(repository),
            getCharacterById = GetCharacterById(repository),
            updateIntimacy = UpdateIntimacy(repository)
        )
    }

    @Provides
    @Singleton
    fun provideFocusHistoryDatabase(app: Application): FocusHistoryDatabase {
        return Room.databaseBuilder(
            app,
            FocusHistoryDatabase::class.java,
            FocusHistoryDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFocusHistoryRepository(db: FocusHistoryDatabase): FocusHistoryRepository {
        return FocusHistoryRepositoryImplementation(db.focusHistoryDao)
    }

    @Provides
    @Singleton
    fun provideFocusHistoryUseCases(repository: FocusHistoryRepository): FocusHistoryUseCases {
        return FocusHistoryUseCases(
            getLastWeekHistory = GetLastWeekHistory(repository),
            getLastWeekHistoryGroupByDay = GetLastWeekHistoryGroupByDay(repository),
            getAllHistory = GetAllHistory(repository),
            insertHistory = InsertHistory(repository)
        )
    }

    @Provides
    @Singleton
    fun provideItemRepository(dataStore: ItemDataStore): ItemRepository {
        return ItemRepositoryImplementation(dataStore)
    }

    @Provides
    @Singleton
    fun provideItemUseCases(repository: ItemRepository): ItemUseCases {
        return ItemUseCases(
            getAllItem = GetAllItem(repository),
            getItemById = GetItemById(repository),
            updateItemOwnedQuantity = UpdateItemOwnedQuantity(repository)
        )
    }

    @Provides
    @Singleton
    fun provideLastFocusSettingRepository(dataStore: LastFocusSettingDataStore): LastFocusSettingRepository {
        return LastFocusSettingRepositoryImplementation(dataStore)
    }

    @Provides
    @Singleton
    fun provideLastFocusSettingUseCases(repository: LastFocusSettingRepository): LastFocusSettingUseCases {
        return LastFocusSettingUseCases(
            getLastFocusSetting = GetLastFocusSetting(repository),
            setLastFocusTime = SetLastFocusTime(repository),
            setLastWork = SetLastWork(repository),
            setLastSceneId = SetLastSceneId(repository)
        )
    }

    @Provides
    @Singleton
    fun providePlotStateRepository(dataStore: PlotStateDataStore): PlotStateRepository {
        return PlotStateRepositoryImplementation(dataStore)
    }

    @Provides
    @Singleton
    fun providePlotStateSettingUseCases(repository: PlotStateRepository): PlotStateUseCases {
        return PlotStateUseCases(
            getPlotState = GetPlotState(repository),
            setPlotState = SetPlotState(repository),
            setPlotStateValue = SetPlotStateValue(repository)
        )
    }

    @Provides
    @Singleton
    fun provideSceneRepository(dataStore: SceneDataStore): SceneRepository {
        return SceneRepositoryImplementation(dataStore)
    }

    @Provides
    @Singleton
    fun provideSceneUseCases(repository: SceneRepository): SceneUseCases {
        return SceneUseCases(
            getAllScene = GetAllScene(repository),
            setSceneIsOwned = SetSceneIsOwned(repository)
        )
    }

    @Provides
    @Singleton
    fun provideSettingRepository(dataStore: SettingDataStore): SettingRepository {
        return SettingRepositoryImplementation(dataStore)
    }

    @Provides
    @Singleton
    fun provideSettingUseCases(repository: SettingRepository): SettingUseCases {
        return SettingUseCases(
            getSetting = GetSetting(repository),
            setSoundEffectVolume = SetSoundEffectVolume(repository),
            setBGMVolume = SetBGMVolume(repository),
            setKeepScreenOpen = SetKeepScreenOpen(repository),
            setLanguage = SetLanguage(repository),
            setRestrictedMode = SetRestrictedMode(repository)
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository(dataStore: UserDataStore): UserRepository {
        return UserRepositoryImplementation(dataStore)
    }

    @Provides
    @Singleton
    fun provideUserUseCases(repository: UserRepository): UserUseCases {
        return UserUseCases(
            getUserInfo = GetUserInfo(repository),
            setId = SetId(repository),
            setUserName = SetUserName(repository),
            setPhotoUrl = SetPhotoUrl(repository),
            setGender = SetGender(repository),
            setBirthday = SetBirthday(repository),
            setJoinDate = SetJoinDate(repository),
            updateMoney = UpdateMoney(repository),
            updateGem = UpdateGem(repository),
            setLastUsedCharacterId = SetLastUsedCharacterId(repository)
        )
    }
}