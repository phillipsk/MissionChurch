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

    @Query("SELECT * FROM highlights WHERE id = :websiteHighlightId")
    fun getHighlight(websiteHighlightId: String): LiveData<WebsiteHighlight>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(highlightList: List<WebsiteHighlight>)

    @Query("SELECT * FROM highlights")
    fun listHighlights(): List<WebsiteHighlight>

}