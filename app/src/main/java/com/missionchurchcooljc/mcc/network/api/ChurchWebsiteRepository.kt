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

package com.missionchurchcooljc.mcc.network.api

import android.util.Log
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import javax.inject.Inject

class ChurchWebsiteRepository @Inject constructor(
//    private val networkClient: NetworkClient<ChurchWebsiteService>
    private val churchWebsiteService: ChurchWebsiteService,
//    private val contextProvider: CoroutineContextProvider,
    val websiteHighlightDAO: WebsiteHighlightDAO
) {
//    TODO: rename to REMOTE repository
//    database has not been initialized - don't need direcr DB instance
//    DAO interface connects with DB


    suspend fun updateHighlightsRemote() {
        val highlights = churchWebsiteService.getHighlightsExternal()
        val whList: List<WebsiteHighlight> = highlights.items
//                    val database = MccRoomDatabase.getInstance(applicationContext)
        Log.d("highlights", whList.joinToString())
        websiteHighlightDAO.insertAll(whList)
    }

//    suspend fun getHighlightsRemote(): ChurchWebsiteResponse {
//        return churchWebsiteService.getHighlightsExternal()
//    }

//    suspend fun retrieveHighlightsAwait() {
//        withContext(contextProvider.context()) {
//            logCoroutine("getHighlights", coroutineContext)
//
//            val cachedHighlightsDeferred = async {
//                logCoroutine("getSavedHighlights", coroutineContext)
//                websiteHighlightDAO.getHighlightsAsList()
//            }
//
//            val cachedHighlights = cachedHighlightsDeferred.await()
//            val apiHighlights = try {
//                churchWebsiteService.getHighlightsExternal().items
////                movieApiService.getMovies(API_KEY).movies
//            } catch (error: Throwable) {
//                null
//            }
//
//            apiHighlights ?: cachedHighlights
//        }
//    }


}