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
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import com.missionchurchcooljc.mcc.persistence.workers.SeedDatabaseWorker
import com.missionchurchcooljc.mcc.utilities.DATABASE_NAME

@Database(entities = [WebsiteHighlight::class], version = 111, exportSchema = false)
abstract class MccRoomDatabase : RoomDatabase() {
    abstract fun websiteHighlightDao(): WebsiteHighlightDAO

    companion object {
        @Volatile
        private var instance: MccRoomDatabase? = null

        fun getInstance(context: Context): MccRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MccRoomDatabase {
            return Room.databaseBuilder(context, MccRoomDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                ).build()
        }

    }
}