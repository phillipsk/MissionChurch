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
lateinit var whList: List<WebsiteHighlight>


    suspend fun updateHighlightsRemote() {
        whList = websiteHighlightDAO.getHighlightsAsList()
//            //Log.d("KP041521", "count :: " + whList.size.toString())

        try {
            val highlights = churchWebsiteService.getHighlightsExternal()
//            whList = highlights.items
            websiteHighlightDAO.clearHighlights()
//            //Log.d("KP041521", "count :: " + whList.size.toString())
//            //Log.d("KP041521", whList.joinToString())
            websiteHighlightDAO.insertAll(highlights.items)

        } catch (e: Throwable) {
            /*
            TODO: handle connection timeout
            * failed to connect to mccooljc.com/45.56.106.240 (port 80) from /100.71.8.80 (port 36642) after 60000ms: isConnected failed: ETIMEDOUT (Connection timed out)
            * */
//            Log.e("KP052821", e.toString())
        }
//            //Log.d("KP041521", "count :: " + whList.size.toString())

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