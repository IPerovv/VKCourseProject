package com.iperovv.vkcourseproject.data.remote.mapper

import com.iperovv.vkcourseproject.data.remote.model.AppSummaryDto
import com.iperovv.vkcourseproject.domain.model.AppSummary
import javax.inject.Inject

class AppSummaryMapper @Inject constructor() {
    fun fromDto(dto: AppSummaryDto): AppSummary =
        AppSummary(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            category = dto.category.toAppCategory(),
            iconUrl = dto.iconUrl,
        )
}
