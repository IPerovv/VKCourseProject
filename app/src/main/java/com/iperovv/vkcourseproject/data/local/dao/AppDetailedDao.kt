package com.iperovv.vkcourseproject.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iperovv.vkcourseproject.data.local.entity.AppDetailedEntity

@Dao
interface AppDetailedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApp(book: AppDetailedEntity)

    @Query("SELECT * FROM detailed_apps WHERE id = :appId")
    suspend fun getAppById(appId: String): AppDetailedEntity?

    @Query("SELECT id FROM detailed_apps")
    suspend fun getAllAppIds(): List<String>
}
