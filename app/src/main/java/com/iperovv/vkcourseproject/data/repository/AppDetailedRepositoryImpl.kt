package com.iperovv.vkcourseproject.data.repository

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.data.local.dao.AppDetailedDao
import com.iperovv.vkcourseproject.data.local.mapper.AppDetailedDatabaseMapper
import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedNetworkMapper
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailedRepositoryImpl @Inject constructor(
    private val appsApi: AppsApi,
    private val appDetailedDao: AppDetailedDao,
    private val appDetailedNetworkMapper: AppDetailedNetworkMapper,
    private val appDetailedDatabaseMapper: AppDetailedDatabaseMapper,
    private val dispatchers: CoroutineDispatchers,
) : AppDetailedRepository {
    override suspend fun getDetailedApp(appId: String): AppDetailed {
        return withContext(dispatchers.io()) {
            val localApp = appDetailedDao.getAppById(appId)
            if (localApp != null) {
                return@withContext appDetailedDatabaseMapper.fromEntity(localApp)
            } else {
                val remoteAppDto = appsApi.getDetailedApp(appId)
                val remoteAppDomain = appDetailedNetworkMapper.fromDto(remoteAppDto)

                val remoteAppEntity = appDetailedDatabaseMapper.toEntity(remoteAppDomain)
                appDetailedDao.insertApp(remoteAppEntity)

                return@withContext remoteAppDomain
            }
        }
    }
}
