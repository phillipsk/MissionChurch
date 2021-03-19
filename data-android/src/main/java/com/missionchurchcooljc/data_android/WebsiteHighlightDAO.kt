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

package com.missionchurchcooljc.data_android

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WebsiteHighlightDAO {
    @Query("SELECT * FROM highlights")
    fun getHighlights(): LiveData<List<WebsiteHighlight>>

    @Query("SELECT * FROM highlights")
    fun getHighlightsAsList(): List<WebsiteHighlight>

    @Query("SELECT * FROM highlights WHERE id = :websiteHighlightId")
    fun getHighlight(websiteHighlightId: String): LiveData<WebsiteHighlight>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(highlightList: List<WebsiteHighlight>)

    /**
     * Select all tasks from the tasks table.
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM highlights")
    fun listHighlights(): List<WebsiteHighlight>

}