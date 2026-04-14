package com.iperovv.vkcourseproject.usecase

import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.usecase.RefreshAppDetailedUseCase
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.Test
import kotlin.test.assertFailsWith

class RefreshAppDetailedUseCaseTest {
    private val repository: AppDetailedRepository = mock()
    private val useCase = RefreshAppDetailedUseCase(repository)

    @Test
    fun `invoke EXPECT repository refreshAppDetailed called`() =
        runTest {
            val appId = "1231-1231-asda-213s"

            useCase(appId)

            verify(repository).refreshAppDetailed(appId)
        }

    @Test
    fun `invoke when repository throws EXPECT exception propagated`() =
        runTest {
            val appId = "1231-1231-asda-213s"

            whenever(repository.refreshAppDetailed(appId))
                .thenThrow(RuntimeException())

            assertFailsWith<RuntimeException> {
                useCase(appId)
            }
        }
}
