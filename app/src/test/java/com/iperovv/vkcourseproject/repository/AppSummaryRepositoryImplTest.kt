package com.iperovv.vkcourseproject.repository

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryNetworkMapper
import com.iperovv.vkcourseproject.data.remote.model.AppSummaryDto
import com.iperovv.vkcourseproject.data.repository.AppSummaryRepositoryImpl
import com.iperovv.vkcourseproject.domain.model.AppSummary
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class AppSummaryRepositoryImplTest {
    @Mock
    private lateinit var appsApi: AppsApi

    @Mock
    private lateinit var mapper: AppSummaryNetworkMapper

    @Mock
    private lateinit var dispatchers: CoroutineDispatchers

    @InjectMocks
    private lateinit var repository: AppSummaryRepositoryImpl

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        whenever(dispatchers.io()).thenReturn(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getApps with valid api response EXPECT mapped list returned`() =
        testScope.runTest {
            val dto1 = mock<AppSummaryDto>()
            val dto2 = mock<AppSummaryDto>()
            val expectedDtoList = listOf(dto1, dto2)

            val mapped1 = mock<AppSummary>()
            val mapped2 = mock<AppSummary>()
            val expectedSummaryList = listOf(mapped1, mapped2)

            whenever(appsApi.getAppList()).thenReturn(expectedDtoList)
            whenever(mapper.fromDto(dto1)).thenReturn(mapped1)
            whenever(mapper.fromDto(dto2)).thenReturn(mapped2)

            val resultDeferred = async { repository.getApps() }

            advanceUntilIdle()

            val result = resultDeferred.await()

            assertEquals(2, result.size)
            assertEquals(expectedSummaryList, result)

            verify(appsApi).getAppList()
            verify(mapper).fromDto(dto1)
            verify(mapper).fromDto(dto2)
            verifyNoMoreInteractions(mapper, appsApi)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getApps with empty api response EXPECT empty list returned`() =
        testScope.runTest {
            val expectedDtoList: List<AppSummaryDto> = emptyList()
            val expectedSummaryList: List<AppSummary> = emptyList()

            whenever(appsApi.getAppList()).thenReturn(expectedDtoList)

            val resultDeferred = async { repository.getApps() }

            advanceUntilIdle()

            val result = resultDeferred.await()

            assertEquals(0, result.size)
            assertEquals(expectedSummaryList, result)

            verify(appsApi).getAppList()
            verifyNoMoreInteractions(appsApi, mapper)
        }

    @Test(expected = RuntimeException::class)
    fun `getApps with api failure EXPECT exception thrown`() =
        testScope.runTest {
            whenever(appsApi.getAppList()).thenThrow(RuntimeException("API failure"))
            repository.getApps()
        }

    @Test(expected = IllegalStateException::class)
    fun `getApps with mapper failure EXPECT exception thrown`() =
        testScope.runTest {
            val dto = mock<AppSummaryDto>()

            whenever(appsApi.getAppList()).thenReturn(listOf(dto))
            whenever(mapper.fromDto(dto)).thenThrow(IllegalStateException())

            repository.getApps()
        }
}
