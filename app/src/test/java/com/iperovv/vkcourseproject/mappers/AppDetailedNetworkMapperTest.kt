@file:Suppress("ktlint:standard:property-naming")

package com.iperovv.vkcourseproject.mappers

import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedNetworkMapper
import com.iperovv.vkcourseproject.data.remote.model.AppDetailedDto
import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import org.junit.Assert.assertEquals
import org.junit.Test

class AppDetailedNetworkMapperTest {
    private val mapper = AppDetailedNetworkMapper()

    @Test
    fun `fromDto with valid dto EXPECT returns correct AppDetailed`() {
        val result = mapper.fromDto(dto)

        assertEquals(domain, result)
    }

    @Test
    fun `fromDto EXPECT always sets isInWishlist to false`() {
        val result = mapper.fromDto(dto)

        assertEquals(false, result.isInWishlist)
    }

    @Test
    fun `fromDto with empty screenshot list EXPECT preserves empty list`() {
        val modifiedDto = dto.copy(screenshotUrlList = emptyList())

        val result = mapper.fromDto(modifiedDto)

        assertEquals(emptyList<String>(), result.screenshotUrlList)
    }

    private companion object TestData {
        const val id = "1231-1231-asda-213s"
        const val name = "Гильдия Героев: Экшен ММО РПГ"
        const val developer = "VK Play"
        val categoryString = "игры"
        val category = AppCategory.GAME
        const val ageRating = 12
        const val size = 223.7f
        const val iconUrl = "https://static.rustore.ru/imgproxy/..."
        val screenshotUrls =
            listOf(
                "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
                "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
                "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
                "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
            )
        const val description = "Легендарный рейд героев..."

        val dto =
            AppDetailedDto(
                id = id,
                name = name,
                developer = developer,
                category = categoryString,
                ageRating = ageRating,
                size = size,
                iconUrl = iconUrl,
                screenshotUrlList = screenshotUrls,
                description = description,
            )

        val domain =
            AppDetailed(
                id = id,
                name = name,
                developer = developer,
                category = category,
                ageRating = ageRating,
                size = size,
                iconUrl = iconUrl,
                screenshotUrlList = screenshotUrls,
                description = description,
                isInWishlist = false,
            )
    }
}
