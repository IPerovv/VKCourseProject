@file:Suppress("ktlint:standard:property-naming")

package com.iperovv.vkcourseproject.usecase

import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppSummary
import com.iperovv.vkcourseproject.domain.usecase.GetListOfAppSummaryUseCase
import kotlinx.coroutines.test.runTest
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GetAppsUseCaseTest {
    private val repository: AppSummaryRepository = mock()
    private val useCase = GetListOfAppSummaryUseCase(repository)

    @Test
    fun `invoke EXPECT returns apps from repository`() =
        runTest {
            val apps =
                listOf(
                    appSummary,
                )

            whenever(repository.getApps()).thenReturn(apps)

            val result = useCase()

            assertEquals(apps, result)
            verify(repository).getApps()
        }

    @Test
    fun `invoke when repository throws EXPECT exception propagated`() =
        runTest {
            whenever(repository.getApps()).thenThrow(RuntimeException())

            assertFailsWith<RuntimeException> {
                useCase()
            }
        }

    private companion object PreviewData {
        const val id = "1231-1231-asda-213s"
        const val name = "Гильдия Героев: Экшен ММО РПГ"
        val category = AppCategory.GAME
        const val iconUrl = "https://static.rustore.ru/imgproxy/..."
        const val descriptionShort = "Легендарный рейд"

        val appSummary =
            AppSummary(
                id = id,
                name = name,
                description = descriptionShort,
                category = category,
                iconUrl = iconUrl,
            )
    }
}
