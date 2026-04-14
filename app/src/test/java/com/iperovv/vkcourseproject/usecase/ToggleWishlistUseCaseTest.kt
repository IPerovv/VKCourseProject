package com.iperovv.vkcourseproject.usecase

import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.usecase.ToggleWishlistUseCase
import kotlinx.coroutines.test.runTest
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import kotlin.test.Test
import kotlin.test.assertFailsWith

class ToggleWishlistUseCaseTest {
    private val repository: AppDetailedRepository = mock()
    private val useCase = ToggleWishlistUseCase(repository)

    @Test
    fun `invoke EXPECT repository toggleWishlist called`() =
        runTest {
            val appId = "1231-1231-asda-213s"

            useCase(appId)

            verify(repository).toggleWishlist(appId)
        }

    @Test
    fun `invoke with blank appId EXPECT IllegalArgumentException`() =
        runTest {
            assertFailsWith<IllegalArgumentException> {
                useCase("")
            }
        }
}
