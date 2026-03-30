package com.iperovv.vkcourseproject.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iperovv.vkcourseproject.data.local.entity.AppDetailedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDetailedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApp(book: AppDetailedEntity)

    @Query("SELECT * FROM detailed_apps WHERE id = :appId")
    fun observeAppById(appId: String): Flow<AppDetailedEntity?>

    @Query("SELECT * FROM detailed_apps WHERE id = :appId")
    suspend fun getAppById(appId: String): AppDetailedEntity?

    @Query("UPDATE detailed_apps SET isInWishlist = :isInWishlist WHERE id = :id")
    suspend fun updateWishlistStatus(
        id: String,
        isInWishlist: Boolean,
    )
}
