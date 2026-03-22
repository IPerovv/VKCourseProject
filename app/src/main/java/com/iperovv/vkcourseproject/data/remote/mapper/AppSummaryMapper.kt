package com.iperovv.vkcourseproject.data.remote.mapper

import com.iperovv.vkcourseproject.data.remote.model.AppSummaryDto
import com.iperovv.vkcourseproject.domain.model.AppSummary

class AppSummaryMapper {
    fun fromDto(dto: AppSummaryDto): AppSummary =
        AppSummary(
            name = dto.name,
            slogan = dto.slogan,
            category = dto.category.toAppCategory(),
            iconUrl = dto.iconUrl,
        )
}
