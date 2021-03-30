/*
 * Copyright (c) 2021 Kevin Phillips, Mission Church of Our Lord Jesus Christ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.missionchurchcooljc.mcc.persistence

import android.content.Context
import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): MccRoomDatabase {
        return MccRoomDatabase.getInstance(context)
    }
//        return Room
////            .build()
//            .databaseBuilder(context, MccRoomDatabase::class.java, DATABASE_NAME)
//            // TODO: remove in production
//            // https://stackoverflow.com/questions/46516830/room-persistent-library-reset-version-to-1
//            .fallbackToDestructiveMigration()
//            .addCallback(
//                object : RoomDatabase.Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
//                        WorkManager.getInstance(context).enqueue(request)
//                    }
//                }
//            ).build()
//    }

    @Provides
    fun provideWebsiteHighlightDAO(mccRoomDatabase: MccRoomDatabase): WebsiteHighlightDAO {
        return mccRoomDatabase.websiteHighlightDao()
    }
}