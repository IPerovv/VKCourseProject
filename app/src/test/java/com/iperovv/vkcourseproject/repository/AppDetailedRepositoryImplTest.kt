@file:Suppress("ktlint:standard:property-naming")

package com.iperovv.vkcourseproject.repository

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.data.local.dao.AppDetailedDao
import com.iperovv.vkcourseproject.data.local.entity.AppDetailedEntity
import com.iperovv.vkcourseproject.data.local.mapper.AppDetailedDatabaseMapper
import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedNetworkMapper
import com.iperovv.vkcourseproject.data.remote.model.AppDetailedDto
import com.iperovv.vkcourseproject.data.repository.AppDetailedRepositoryImpl
import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.inOrder
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class AppDetailedRepositoryImplTest {
    @Mock
    private lateinit var appsApi: AppsApi

    @Mock
    private lateinit var appDetailedDao: AppDetailedDao

    @Mock
    private lateinit var networkMapper: AppDetailedNetworkMapper

    @Mock
    private lateinit var databaseMapper: AppDetailedDatabaseMapper

    @Mock
    private lateinit var dispatchers: CoroutineDispatchers

    @InjectMocks
    private lateinit var repository: AppDetailedRepositoryImpl

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        whenever(dispatchers.io()).thenReturn(testDispatcher)
    }

    @Test
    fun `toggleWishlist when item not in wishlist EXPECT set true`() =
        testScope.runTest {
            val existingEntity = entity.copy(isInWishlist = false)
            whenever(appDetailedDao.getAppById(appId)).thenReturn(existingEntity)

            repository.toggleWishlist(appId)

            verify(appDetailedDao).getAppById(appId)
            verify(appDetailedDao).updateWishlistStatus(appId, true)
            verifyNoMoreInteractions(appDetailedDao)
        }

    @Test
    fun `toggleWishlist when item already in wishlist EXPECT set false`() =
        testScope.runTest {
            val existingEntity = entity.copy(isInWishlist = true)
            whenever(appDetailedDao.getAppById(appId)).thenReturn(existingEntity)

            repository.toggleWishlist(appId)

            verify(appDetailedDao).getAppById(appId)
            verify(appDetailedDao).updateWishlistStatus(appId, false)
            verifyNoMoreInteractions(appDetailedDao)
        }

    @Test
    fun `toggleWishlist when local data does not exist EXPECT no update call`() =
        testScope.runTest {
            whenever(appDetailedDao.getAppById(appId)).thenReturn(null)

            repository.toggleWishlist(appId)

            verify(appDetailedDao).getAppById(appId)
            verify(appDetailedDao, never()).updateWishlistStatus(any(), any())
            verifyNoMoreInteractions(appDetailedDao)
        }

    @Test
    fun `observeAppDetailed when data exists EXPECT mapped value`() =
        testScope.runTest {
            whenever(appDetailedDao.observeAppById(appId)).thenReturn(flowOf(entity))
            whenever(databaseMapper.fromEntity(entity)).thenReturn(domain)

            val result = repository.observeAppDetailed(appId).first()

            assertEquals(domain, result)

            verify(appDetailedDao).observeAppById(appId)
            verify(databaseMapper).fromEntity(entity)
        }

    @Test
    fun `observeAppDetailed when null emitted EXPECT filtered out`() =
        testScope.runTest {
            whenever(appDetailedDao.observeAppById(appId))
                .thenReturn(flowOf(null, entity))
            whenever(databaseMapper.fromEntity(entity)).thenReturn(domain)

            val result = repository.observeAppDetailed(appId).first()

            assertEquals(domain, result)

            verify(appDetailedDao).observeAppById(appId)
            verify(databaseMapper).fromEntity(entity)
        }

    @Test
    fun `refreshAppDetailed when local app exists EXPECT update existing entry`() =
        testScope.runTest {
            val existingEntity = entity.copy(isInWishlist = true)

            whenever(appsApi.getDetailedApp(appId)).thenReturn(dto)
            whenever(networkMapper.fromDto(dto)).thenReturn(domain)
            whenever(databaseMapper.toEntity(domain)).thenReturn(entity)
            whenever(appDetailedDao.getAppById(appId)).thenReturn(existingEntity)

            repository.refreshAppDetailed(appId)

            inOrder(appsApi, networkMapper, databaseMapper, appDetailedDao) {
                verify(appsApi).getDetailedApp(appId)
                verify(networkMapper).fromDto(dto)
                verify(databaseMapper).toEntity(domain)
                verify(appDetailedDao).getAppById(appId)
            }

            verify(appDetailedDao).updateAppDetails(
                id = entity.id,
                name = entity.name,
                developer = entity.developer,
                category = entity.category,
                ageRating = entity.ageRating,
                size = entity.size,
                iconUrl = entity.iconUrl,
                screenshotUrlList = entity.screenshotUrlList,
                description = entity.description,
            )

            verify(appDetailedDao, never()).insertApp(any())
        }

    @Test
    fun `refreshAppDetailed when local app does not exist EXPECT insert new entry`() =
        testScope.runTest {
            whenever(appsApi.getDetailedApp(appId)).thenReturn(dto)
            whenever(networkMapper.fromDto(dto)).thenReturn(domain)
            whenever(databaseMapper.toEntity(domain)).thenReturn(entity)
            whenever(appDetailedDao.getAppById(appId)).thenReturn(null)

            repository.refreshAppDetailed(appId)

            inOrder(appsApi, networkMapper, databaseMapper, appDetailedDao) {
                verify(appsApi).getDetailedApp(appId)
                verify(networkMapper).fromDto(dto)
                verify(databaseMapper).toEntity(domain)
                verify(appDetailedDao).getAppById(appId)
            }

            verify(appDetailedDao).insertApp(entity)

            verify(appDetailedDao, never()).updateAppDetails(
                any(),
                any(),
                any(),
                any(),
                any(),
                any(),
                any(),
                any(),
                any(),
            )
        }

    @Test(expected = RuntimeException::class)
    fun `refreshAppDetailed when API throws exception EXPECT exception propagated`() =
        testScope.runTest {
            whenever(appsApi.getDetailedApp(appId)).thenThrow(RuntimeException("Network error"))
            repository.refreshAppDetailed(appId)
        }

    @Test(expected = IllegalStateException::class)
    fun `refreshAppDetailed when network mapper throws EXPECT exception propagated`() =
        testScope.runTest {
            whenever(appsApi.getDetailedApp(appId)).thenReturn(dto)
            whenever(networkMapper.fromDto(dto)).thenThrow(IllegalStateException("Mapping error"))
            repository.refreshAppDetailed(appId)
        }

    @Test(expected = IllegalStateException::class)
    fun `refreshAppDetailed when database mapper throws EXPECT exception propagated`() =
        testScope.runTest {
            whenever(appsApi.getDetailedApp(appId)).thenReturn(dto)
            whenever(networkMapper.fromDto(dto)).thenReturn(domain)
            whenever(databaseMapper.toEntity(domain)).thenThrow(IllegalStateException("Mapping error"))
            repository.refreshAppDetailed(appId)
        }

    private companion object TestData {
        const val appId = "1231-1231-asda-213s"
        const val name = "Гильдия Героев: Экшен ММО РПГ"
        const val description = "Легендарный рейд героев..."
        const val iconUrl = "https://static.rustore.ru/imgproxy/..."
        const val developer = "SuperDev"
        const val categoryString = "игры"
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

        val dto =
            AppDetailedDto(
                id = appId,
                name = name,
                description = description,
                category = categoryString,
                iconUrl = iconUrl,
                developer = developer,
                ageRating = ageRating,
                size = size,
                screenshotUrlList = screenshotUrlList,
            )

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

        val entity =
            AppDetailedEntity(
                id = appId,
                name = name,
                developer = developer,
                category = category,
                ageRating = ageRating,
                size = size,
                iconUrl = iconUrl,
                screenshotUrlList = screenshotUrlList,
                description = description,
                isInWishlist = isInWishlist,
            )
    }
}
