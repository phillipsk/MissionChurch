package io.techministry.android.missionchurch.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import io.techministry.android.missionchurch.persistence.workers.SeedDatabaseWorker
import io.techministry.android.missionchurch.utilities.DATABASE_NAME

@Database(entities = [WebsiteHighlight::class], version = 1, exportSchema = false)
abstract class MccRoomDatabase : RoomDatabase() {
    abstract fun websiteHighlightDao(): WebsiteHighlightDAO

    companion object {
        private var instance: MccRoomDatabase? = null

        fun getInstance(context: Context): MccRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MccRoomDatabase {
            return Room.databaseBuilder(context, MccRoomDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                ).build()
        }

    }
}