package com.missionchurchcooljc.mcc.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import com.missionchurchcooljc.mcc.persistence.MccRoomDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MccRoomDatabase {
        return MccRoomDatabase.getInstance(context)
    }

    @Provides
    fun provideWebsiteHighlightDAO(appDatabase: MccRoomDatabase): WebsiteHighlightDAO {
        return appDatabase.websiteHighlightDao()
    }
}