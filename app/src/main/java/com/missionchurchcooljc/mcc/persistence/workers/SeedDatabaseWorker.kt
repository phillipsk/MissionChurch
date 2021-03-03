package com.missionchurchcooljc.mcc.persistence.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.missionchurchcooljc.data_android.WebsiteHighlightResponse
import com.missionchurchcooljc.mcc.persistence.MccRoomDatabase
import com.missionchurchcooljc.mcc.utilities.ABOUT_US_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {
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

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(ABOUT_US_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val whType = object : TypeToken<WebsiteHighlightResponse>() {}.type
                    val whList: WebsiteHighlightResponse = Gson().fromJson(jsonReader,whType)
                    val database = MccRoomDatabase.getInstance(applicationContext)
                    database.websiteHighlightDao().insertAll(whList.data)
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
