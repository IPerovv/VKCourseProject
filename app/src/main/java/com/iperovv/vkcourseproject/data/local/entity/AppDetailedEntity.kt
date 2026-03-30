package com.iperovv.vkcourseproject.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iperovv.vkcourseproject.domain.model.AppCategory

@Entity(tableName = "detailed_apps")
data class AppDetailedEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val developer: String,
    val category: AppCategory,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
    val isInWishlist: Boolean = false,
)
