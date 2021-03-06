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

package com.missionchurchcooljc.mcc.feature_highlights

import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebsiteRepository @Inject constructor(
    private val websiteHighlightDAO: WebsiteHighlightDAO
) {

    //    TODO: rename to LOCAL repository
    private val job: Job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun getHighlights() = websiteHighlightDAO.getHighlights()
//    fun purgeHighlights() =
//        coroutineScope.launch(Dispatchers.IO) { websiteHighlightDAO.clearHighlights() }

    fun getHighlightsAsList() = websiteHighlightDAO.getHighlightsAsList()
    fun getHighlight(websiteHighlightId: String) =
        websiteHighlightDAO.getHighlight(websiteHighlightId)


}
