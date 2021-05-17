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

package com.missionchurchcooljc.mcc

import com.missionchurchcooljc.mcc.network.api.ChurchWebsiteService
import okhttp3.OkHttpClient
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTest {
    private val okHttpClient = OkHttpClient.Builder().build()
    private val endpoint: String = "http://god.works/"

    @Before
    fun setUp() {
    }
    @Test
    fun getHighlightsFromWebsite() {


        val retrofit = Retrofit.Builder()
            .baseUrl(endpoint)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
//            .create(ChurchWebsiteService::class.java)

        val churchWebsiteService: ChurchWebsiteService =
            retrofit.create<ChurchWebsiteService>(ChurchWebsiteService::class.java)

//        val wh = churchWebsiteService.getHighlightsExternal().execute()
        val whB = churchWebsiteService.getHighlightsExternalB().execute()

//        assertThat(wh.isSuccessful, CoreMatchers.equalTo(true))
        assertThat(whB.isSuccessful, CoreMatchers.equalTo(true))

//        val resultList = ChurchWebsiteResponse(wh.body()?.items ?: emptyList())
//        assertThat(resultList.items.size, CoreMatchers.equalTo(15))
//        val resultListB = ChurchWebsiteResponse(whB.body())
//        assertThat(resultListB.items.size, CoreMatchers.equalTo(14))


//        val response = Response<ChurchWebsiteResponse>

//        Assert.assertThat(wListII.size, CoreMatchers.equalTo(14))
//        Assert.assertThat(wListII[0], CoreMatchers.equalTo(wh1))
//        Assert.assertThat(wListII[1], CoreMatchers.equalTo(wh2))
    }


}