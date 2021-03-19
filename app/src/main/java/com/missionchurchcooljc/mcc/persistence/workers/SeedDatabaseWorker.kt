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

package com.missionchurchcooljc.mcc.persistence.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.mcc.persistence.MccRoomDatabase
import com.missionchurchcooljc.mcc.utilities.ABOUT_US_DATA_FILENAME
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SeedDatabaseWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    @Inject
    lateinit var mccRoomDatabase: MccRoomDatabase

//    override suspend fun doWork(): Result {
//        var f = applicationContext.assets.open(ABOUT_US_DATA_FILENAME)
////        var r = com.google.gson.stream.JsonReader(f.reader())
//        val jsonReader = com.google.gson.stream.JsonReader(f.reader())
//        val whType = object : TypeToken<List<WebsiteHighlight>>() {}.type
//        val whList: List<WebsiteHighlight> = Gson().fromJson(jsonReader, whType)
//        val database = MccRoomDatabase.getInstance(applicationContext)
//        database.websiteHighlightDao().insertAll(whList)
//       return Result.success()
//    }

    override suspend fun doWork() = coroutineScope {
        try {
            applicationContext.assets.open(ABOUT_US_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val whType = object : TypeToken<List<WebsiteHighlight>>() {}.type
                    val whList: List<WebsiteHighlight> = Gson().fromJson(jsonReader, whType)
//                    val database = MccRoomDatabase.getInstance(applicationContext)
                    mccRoomDatabase.websiteHighlightDao().insertAll(whList)
//
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
    }


}
