package com.iperovv.vkcourseproject.data.repository

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedNetworkMapper
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailedRepositoryImpl @Inject constructor(
    private val appsApi: AppsApi,
    private val appDetailedNetworkMapper: AppDetailedNetworkMapper,
    private val dispatchers: CoroutineDispatchers,
) : AppDetailedRepository {
    override suspend fun getDetailedApp(appId: String): AppDetailed =
        withContext(dispatchers.io()) {
            val appDetailedDto = appsApi.getDetailedApp(appId)
            val appDetailed = appDetailedNetworkMapper.fromDto(appDetailedDto)
            return@withContext appDetailed
        }
}
