package com.iperovv.vkcourseproject.data.local.mapper

import com.iperovv.vkcourseproject.data.local.entity.AppDetailedEntity
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import javax.inject.Inject

class AppDetailedDatabaseMapper @Inject constructor() {
    fun fromEntity(entity: AppDetailedEntity): AppDetailed =
        AppDetailed(
            id = entity.id,
            name = entity.name,
            developer = entity.developer,
            category = entity.category,
            ageRating = entity.ageRating,
            size = entity.size,
            iconUrl = entity.iconUrl,
            screenshotUrlList = entity.screenshotUrlList,
            description = entity.description,
            isInWishlist = entity.isInWishlist,
        )

    fun toEntity(domain: AppDetailed): AppDetailedEntity =
        AppDetailedEntity(
            id = domain.id,
            name = domain.name,
            developer = domain.developer,
            category = domain.category,
            ageRating = domain.ageRating,
            size = domain.size,
            iconUrl = domain.iconUrl,
            screenshotUrlList = domain.screenshotUrlList,
            description = domain.description,
            isInWishlist = domain.isInWishlist,
        )
}
