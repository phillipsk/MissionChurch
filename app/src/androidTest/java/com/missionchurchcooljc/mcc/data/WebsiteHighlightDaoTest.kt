/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.missionchurchcooljc.mcc.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import com.missionchurchcooljc.mcc.persistence.MccRoomDatabase
import com.missionchurchcooljc.mcc.utilities.ABOUT_US_DATA_FILENAME
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WebsiteHighlightDaoTest {
    private lateinit var database: MccRoomDatabase
    private lateinit var websiteHighlightDAO: WebsiteHighlightDAO

    private val wh1 = WebsiteHighlight(
        "ctfw-highlight-3",
        "https://toolbox-media.com/missioncooljc/wp-content/uploads/2020/04/2020-04-01-06_50_47-BIBLE-STUDY-WITH-PASTOR-MITCHELL-TONIGHT-@-7_30PM-TUESDAY-MARCH-24TH-Messag-600x410.png",
        "Our Pastor",
        "https://toolbox-media.com/missioncooljc/index.php/people/bishop-malcolm-mitchell/",
        "Bishop Malcolm D. Mitchell",
        "600",
        "410"

    )

    private val wh2 = WebsiteHighlight(
        "ctfw-highlight-61",
        "https://toolbox-media.com/missioncooljc/wp-content/uploads/2020/12/SUNDAY-WORSHIP-600x410.jpg",
        null,
        "https://us02web.zoom.us/j/82022507181?pwd=KzZGTEpVbno0Rnh3ZklCVUtNbS9BZz09",
        "Meeting ID: 820 2250 7181 Passcode: 683745",
        "600",
        "410"

    )
    private val wh3 = WebsiteHighlight(
        "ctfw-highlight-52",
        "https://toolbox-media.com/missioncooljc/wp-content/uploads/2020/12/Copy-of-church-youtube-thumbnail-template-1-600x410.jpg",
        null,
        "https://us02web.zoom.us/j/723115841",
        "2nd and 4th Sundays 10:00AM \u2022 Ages (13-17) Meeting ID: 723 115 841",
        "600",
        "410"

    )
    private val wh4 = WebsiteHighlight(
        "ctfw-highlight-58",
        "https://toolbox-media.com/missioncooljc/wp-content/uploads/2015/06/image_link2-600x410.jpg",
        "CHURCH MOTHER\u2019S PRAYER FOR DECEMBER",
        "http://toolbox-media.com/missioncooljc/wp-content/uploads/2020/12/December-.jpg",
        null,
        "600",
        "410"

    )

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, MccRoomDatabase::class.java).build()
        websiteHighlightDAO = database.websiteHighlightDao()

        // Insert plants in non-alphabetical order to test that results are sorted by name
//        websiteHighlightDAO.insertAll(listOf(wh2, wh3, wh1))

        val f = context.assets.open(ABOUT_US_DATA_FILENAME)
        val jsonReader = JsonReader(f.reader())
        val whType = object : TypeToken<List<WebsiteHighlight>>() {}.type
        val whList: List<WebsiteHighlight> = Gson().fromJson(jsonReader, whType)
        websiteHighlightDAO.insertAll(whList)

    }

    @Test
    fun testGetHighlights() {
//        LiveData type
//        val wListI = getValue(websiteHighlightDAO.getHighlights())
//        assertThat(wListI.size, equalTo(4))
//        List type
        val wListII = websiteHighlightDAO.listHighlights()
        assertThat(wListII.size, equalTo(14))

        assertThat(wListII[0], equalTo(wh1))
        assertThat(wListII[1], equalTo(wh2))

    }
    @Test
    fun checkHighlight3(){
        val wListII = websiteHighlightDAO.listHighlights()
        assertThat(wListII[9], equalTo(wh3))
    }
    @Test
    fun checkHighlight4(){
        val wListII = websiteHighlightDAO.listHighlights()
        assertThat(wListII[11], equalTo(wh4))
    }




    // Ensure plant list is sorted by name
//        assertThat(plantList[0], equalTo(wh1))
//        assertThat(plantList[1], equalTo(wh2))
//        assertThat(plantList[2], equalTo(wh3))

    @After
    fun closeDb() {
        database.close()
    }

//    @Test fun testGetPlantsWithGrowZoneNumber() {
//        val plantList = getValue(websiteHighlightDAO.getPlantsWithGrowZoneNumber(1))
//        assertThat(plantList.size, equalTo(2))
//        assertThat(getValue(websiteHighlightDAO.getPlantsWithGrowZoneNumber(2)).size, equalTo(1))
//        assertThat(getValue(websiteHighlightDAO.getPlantsWithGrowZoneNumber(3)).size, equalTo(0))
//
//        // Ensure plant list is sorted by name
//        assertThat(plantList[0], equalTo(wh1))
//        assertThat(plantList[1], equalTo(wh2))
//    }

//    @Test fun testGetPlant() {
//        assertThat(getValue(websiteHighlightDAO.getHighlight(wh1.websiteHighlightId)), equalTo(wh1))
//    }
}
