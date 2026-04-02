@file:Suppress("ktlint:standard:property-naming")

package com.iperovv.vkcourseproject.mappers

import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryNetworkMapper
import com.iperovv.vkcourseproject.data.remote.model.AppSummaryDto
import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppSummary
import org.junit.Assert.assertEquals
import org.junit.Test

class AppSummaryNetworkMapperTest {
    private val mapper = AppSummaryNetworkMapper()

    @Test
    fun `fromDto with valid dto EXPECT returns correct AppSummary`() {
        val result = mapper.fromDto(dto)

        assertEquals(domain, result)
    }

    @Test
    fun `fromDto with different category EXPECT correctly maps category`() {
        val modifiedDto = dto.copy(category = "музыка")

        val result = mapper.fromDto(modifiedDto)

        assertEquals(AppCategory.MUSIC, result.category)
    }

    @Test
    fun `fromDto with unknown category EXPECT returns APP category`() {
        val modifiedDto = dto.copy(category = "неверная категория")

        val result = mapper.fromDto(modifiedDto)

        assertEquals(AppCategory.APP, result.category)
    }

    private companion object TestData {
        const val id = "1231-1231-asda-213s"
        const val name = "Гильдия Героев: Экшен ММО РПГ"
        const val description = "Легендарный рейд героев..."
        const val iconUrl = "https://static.rustore.ru/imgproxy/..."

        val categoryString = "игры"
        val category = AppCategory.GAME

        val dto =
            AppSummaryDto(
                id = id,
                name = name,
                description = description,
                category = categoryString,
                iconUrl = iconUrl,
            )

        val domain =
            AppSummary(
                id = id,
                name = name,
                description = description,
                category = category,
                iconUrl = iconUrl,
            )
    }
}
