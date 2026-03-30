package com.iperovv.vkcourseproject.data.repository

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.data.local.dao.AppDetailedDao
import com.iperovv.vkcourseproject.data.local.mapper.AppDetailedDatabaseMapper
import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedNetworkMapper
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppDetailedRepositoryImpl @Inject constructor(
    private val appsApi: AppsApi,
    private val appDetailedDao: AppDetailedDao,
    private val appDetailedNetworkMapper: AppDetailedNetworkMapper,
    private val appDetailedDatabaseMapper: AppDetailedDatabaseMapper,
    private val dispatchers: CoroutineDispatchers,
) : AppDetailedRepository {
    override suspend fun toggleWishlist(id: String) {
    }

    override fun observeAppDetailed(id: String): Flow<AppDetailed> =
        appDetailedDao
            .observeAppById(id)
            .filterNotNull()
            .map {
                appDetailedDatabaseMapper.fromEntity(it)
            }.flowOn(dispatchers.io())

    override suspend fun refreshAppDetailed(appId: String) {
        val remoteAppDto = appsApi.getDetailedApp(appId)
        val remoteAppDomain = appDetailedNetworkMapper.fromDto(remoteAppDto)
        val remoteAppEntity = appDetailedDatabaseMapper.toEntity(remoteAppDomain)
        appDetailedDao.insertApp(remoteAppEntity)
    }
}
