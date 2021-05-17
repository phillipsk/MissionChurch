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

import android.util.Log
import com.missionchurchcooljc.mcc.network.api.ChurchWebsiteResponse
import com.missionchurchcooljc.mcc.network.api.ChurchWebsiteService
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader

class RetrofitTestMock {
    private val okHttpClient = OkHttpClient.Builder().build()
    private val endpoint: String = "http://god.works/"

    lateinit var mockWebServer: MockWebServer
    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
    }
    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }


    @Test
    fun getHighlightsFromWebsite() {

        val callback = object : Callback<ChurchWebsiteResponse> {
            override fun onFailure(call: Call<ChurchWebsiteResponse>?, t: Throwable?) {
                Log.e("RetrofitTest", "Problem calling Github API ${t?.message}")
            }

            override fun onResponse(
                call: Call<ChurchWebsiteResponse>?,
                response: Response<ChurchWebsiteResponse>?
            ) {
//                response?.isSuccessful.let {
//                    val resultList = ChurchWebsiteResponse(response?.body()?.items ?: emptyList())
////                    repoList.adapter = RepoListAdapter(resultList)
//                    Log.d("Test",
//                        "WebsiteHighlight List Count ${resultList.items.size}")
//
//                }
            }
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(endpoint)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ChurchWebsiteService::class.java)
//
//        mockWebServer.apply{
//            enqueue(MockResponse().setBody(MockResponseFileReader("login_success.json").content))
//        }
//        val requestBody = mockWebServer.takeRequest().body.readUtf8()

//        val wh = retrofit.getHighlightsExternal().execute()
        val whB = retrofit.getHighlightsExternalB().execute()

//        assertThat(wh.isSuccessful, CoreMatchers.equalTo(true))
        assertThat(whB.isSuccessful, CoreMatchers.equalTo(true))
//        val response = Response<ChurchWebsiteResponse>
//        val resultList = ChurchWebsiteResponse(wh.body()?.items ?: emptyList())
//        assertThat(resultList.items.size,CoreMatchers.equalTo(13))


//        Assert.assertThat(wListII.size, CoreMatchers.equalTo(14))
//
//        Assert.assertThat(wListII[0], CoreMatchers.equalTo(wh1))
//        Assert.assertThat(wListII[1], CoreMatchers.equalTo(wh2))
    }


    class MockResponseFileReader(path: String) {
        val content: String

        init {
            val reader = InputStreamReader(this.javaClass.classLoader.getResourceAsStream(path))
            content = reader.readText()
            reader.close()
        }
    }

}