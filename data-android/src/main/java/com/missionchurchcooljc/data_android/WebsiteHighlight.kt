package com.missionchurchcooljc.data_android

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "highlights")
data class WebsiteHighlight(
    @PrimaryKey @ColumnInfo(name = "id") val highlightId: String,
    val imageUrl: String?,
    val title: String?,
    val followUrl: String?,
    val caption: String?,
    @SerializedName("width") val imageWidth: String?,
    @SerializedName("height") val imageHeight: String?
)

data class WebsiteHighlightResponse(
    @SerializedName("data") val data: List<WebsiteHighlight>
)