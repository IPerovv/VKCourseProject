package com.iperovv.vkcourseproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iperovv.vkcourseproject.data.local.dao.AppDetailedDao
import com.iperovv.vkcourseproject.data.local.entity.AppDetailedEntity
import com.iperovv.vkcourseproject.data.local.util.Converters

@Database(
    entities = [AppDetailedEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDetailedDao(): AppDetailedDao
}
