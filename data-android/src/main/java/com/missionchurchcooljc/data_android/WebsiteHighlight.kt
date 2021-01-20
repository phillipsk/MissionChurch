package com.missionchurchcooljc.data_android

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "highlights")
data class WebsiteHighlight(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val highlightId: String,
    val imageUrl: String?,
    val title: String?,
    val followUrl: String?,
    val caption: String?,
    @SerializedName("width")
    val imageWidth: String?,
    @SerializedName("height")
    val imageHeight: String?
) {


//        /**
//         * Determines if the plant should be watered.  Returns true if [since]'s date > date of last
//         * watering + watering Interval; false otherwise.
//         */
//        fun shouldBeWatered(since: Calendar, lastWateringDate: Calendar) =
//            since > lastWateringDate.apply { add(Calendar.DAY_OF_YEAR, wateringInterval) }

//    override fun toString(): String = name
}
