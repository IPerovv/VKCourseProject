package com.iperovv.vkcourseproject.data.remote.mapper

import com.iperovv.vkcourseproject.data.remote.model.AppDetailedDto
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import javax.inject.Inject

class AppDetailedMapper @Inject constructor() {
    fun fromDto(dto: AppDetailedDto): AppDetailed =
        AppDetailed(
            id = dto.id,
            name = dto.name,
            developer = dto.developer,
            category = dto.category.toAppCategory(),
            ageRating = dto.ageRating,
            size = dto.size,
            iconUrl = dto.iconUrl,
            screenshotUrlList = dto.screenshotUrlList,
            description = dto.description,
        )
}
