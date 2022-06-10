package com.ss_team_1.koibitoshuuchuu.di

import android.app.Application
import androidx.room.Room
import com.ss_team_1.koibitoshuuchuu.data.data_source.character.CharacterDataStore
import com.ss_team_1.koibitoshuuchuu.data.data_source.focusHistory.FocusHistoryDatabase
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.CharacterRepositoryImplementation
import com.ss_team_1.koibitoshuuchuu.data.repository_implementation.FocusHistoryRepositoryImplementation
import com.ss_team_1.koibitoshuuchuu.domain.repository.CharacterRepository
import com.ss_team_1.koibitoshuuchuu.domain.repository.FocusHistoryRepository
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.CharacterUseCases
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.GetAllCharacter
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.GetCharacterById
import com.ss_team_1.koibitoshuuchuu.domain.use_case.character.UpdateIntimacy
import com.ss_team_1.koibitoshuuchuu.domain.use_case.focusHistory.*
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
            insertHistory = InsertHistory(repository),        )
    }
}