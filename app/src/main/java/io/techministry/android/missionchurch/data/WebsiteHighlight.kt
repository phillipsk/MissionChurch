package io.techministry.android.missionchurch.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "highlights")
data class WebsiteHighlight(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val websiteHighlightId: String,
    val imageUrl: String,
    val name: String,
    val zoomUrl: String,
    val detailUrl: String,
    val detail_description: String = ""
) {

//        /**
//         * Determines if the plant should be watered.  Returns true if [since]'s date > date of last
//         * watering + watering Interval; false otherwise.
//         */
//        fun shouldBeWatered(since: Calendar, lastWateringDate: Calendar) =
//            since > lastWateringDate.apply { add(Calendar.DAY_OF_YEAR, wateringInterval) }

    override fun toString() = name
}
