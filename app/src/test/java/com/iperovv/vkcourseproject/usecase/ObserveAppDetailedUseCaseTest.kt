@file:Suppress("ktlint:standard:property-naming")

package com.iperovv.vkcourseproject.usecase

import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import com.iperovv.vkcourseproject.domain.usecase.ObserveAppDetailedUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.Test
import kotlin.test.assertEquals

class ObserveAppDetailedUseCaseTest {
    private val repository: AppDetailedRepository = mock()
    private val useCase = ObserveAppDetailedUseCase(repository)

    @Test
    fun `invoke EXPECT flow from repository returned`() =
        runTest {
            val appId = appId
            val expected = domain

            whenever(repository.observeAppDetailed(appId))
                .thenReturn(flowOf(expected))

            val result = useCase(appId).first()

            assertEquals(expected, result)
            verify(repository).observeAppDetailed(appId)
        }

    private companion object TestData {
        const val appId = "1231-1231-asda-213s"
        const val name = "Гильдия Героев: Экшен ММО РПГ"
        const val description = "Легендарный рейд героев..."
        const val iconUrl = "https://static.rustore.ru/imgproxy/..."
        const val developer = "SuperDev"
        val category = AppCategory.GAME
        const val ageRating = 12
        const val size = 223.7f
        val screenshotUrlList =
            listOf(
                "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
                "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
                "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
                "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
            )
        const val isInWishlist = false

        val domain =
            AppDetailed(
                id = appId,
                name = name,
                description = description,
                category = category,
                iconUrl = iconUrl,
                developer = developer,
                ageRating = ageRating,
                size = size,
                screenshotUrlList = screenshotUrlList,
                isInWishlist = isInWishlist,
            )
    }
}
