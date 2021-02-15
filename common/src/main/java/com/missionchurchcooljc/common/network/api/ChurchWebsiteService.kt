/*
 * Copyright (c) 2021  Kevin Phillips, Mission Church of Our Lord Jesus Christ
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

package com.missionchurchcooljc.common.network.api

import com.missionchurchcooljc.data_android.WebsiteHighlight
import retrofit2.Call
import retrofit2.http.GET

interface ChurchWebsiteService {

    @GET("android/highlights.json")
    fun getHighlightsExternal(): Call<ChurchWebsiteResponse>

    @GET("android/highlights.json")
    fun getHighlightsExternalB(): Call<WebsiteHighlight>
//    @GET("android")
//    fun getHighlightsExternal(): Call<List<WebsiteHighlight>>


//    TODO: refactor repository, move retrofit into this class
//      to do this, use the new dagger provides instance of Retrofit
//      from the Network module
//      With sunflower the API call is from the ViewModel and the
//      coroutine scope is on the Fragment
//      Sunflower has retrofit service in here
}