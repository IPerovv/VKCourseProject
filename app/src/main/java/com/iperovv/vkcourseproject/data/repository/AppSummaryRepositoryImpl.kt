package com.iperovv.vkcourseproject.data.repository

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryNetworkMapper
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import com.iperovv.vkcourseproject.domain.model.AppSummary
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppSummaryRepositoryImpl @Inject constructor(
    private val appsApi: AppsApi,
    private val appSummaryNetworkMapper: AppSummaryNetworkMapper,
    private val dispatchers: CoroutineDispatchers,
) : AppSummaryRepository {
    override suspend fun getApps(): List<AppSummary> =
        withContext(dispatchers.io()) {
            appsApi
                .getAppList()
                .map(appSummaryNetworkMapper::fromDto)
        }
}
