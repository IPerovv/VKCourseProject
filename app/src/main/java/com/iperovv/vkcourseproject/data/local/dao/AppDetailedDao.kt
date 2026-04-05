package com.iperovv.vkcourseproject.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iperovv.vkcourseproject.data.local.entity.AppDetailedEntity
import com.iperovv.vkcourseproject.domain.model.AppCategory
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

    @Query(
        """
        UPDATE detailed_apps 
        SET name = :name,
            developer = :developer,
            category = :category,
            ageRating = :ageRating,
            size = :size,
            iconUrl = :iconUrl,
            screenshotUrlList = :screenshotUrlList,
            description = :description
        WHERE id = :id
    """,
    )
    suspend fun updateAppDetails(
        id: String,
        name: String,
        developer: String,
        category: AppCategory,
        ageRating: Int,
        size: Float,
        iconUrl: String,
        screenshotUrlList: List<String>,
        description: String,
    )
}
