@file:Suppress("ktlint:standard:property-naming")

package com.iperovv.vkcourseproject.mappers

import com.iperovv.vkcourseproject.data.local.entity.AppDetailedEntity
import com.iperovv.vkcourseproject.data.local.mapper.AppDetailedDatabaseMapper
import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import org.junit.Assert.assertEquals
import org.junit.Test

class AppDetailedDatabaseMapperTest {
    private val mapper = AppDetailedDatabaseMapper()

    @Test
    fun `fromEntity with valid entity EXPECT returns correct AppDetailed`() {
        val entity = appDetailedEntity

        val domain = mapper.fromEntity(entity)

        assertEquals(appDetailed, domain)
    }

    @Test
    fun `toEntity with valid domain EXPECT returns correct AppDetailedEntity`() {
        val domain = appDetailed

        val entity = mapper.toEntity(domain)

        assertEquals(appDetailedEntity, entity)
    }

    @Test
    fun `toEntity and then fromEntity with valid domain EXPECT preserves original object`() {
        val original = appDetailed

        val entity = mapper.toEntity(original)
        val restored = mapper.fromEntity(entity)

        assertEquals(original, restored)
    }

    @Test
    fun `fromEntity with empty screenshot list EXPECT preserves empty list`() {
        val entity = appDetailedEntity.copy(screenshotUrlList = emptyList())

        val domain = mapper.fromEntity(entity)

        assertEquals(emptyList<String>(), domain.screenshotUrlList)
    }

    @Test
    fun `fromEntity with very long description EXPECT preserves long description`() {
        val longDescription = "A".repeat(10000)
        val entity = appDetailedEntity.copy(description = longDescription)

        val domain = mapper.fromEntity(entity)

        assertEquals(longDescription, domain.description)
    }

    private companion object TestData {
        const val id = "1231-1231-asda-213s"
        const val name = "Гильдия Героев: Экшен ММО РПГ"
        const val developer = "VK Play"
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

        val appDetailed =
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

        val appDetailedEntity =
            AppDetailedEntity(
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
