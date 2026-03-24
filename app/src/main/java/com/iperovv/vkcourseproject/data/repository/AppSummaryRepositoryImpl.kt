package com.iperovv.vkcourseproject.data.repository

import com.iperovv.vkcourseproject.common.dispatchers.CoroutineDispatchers
import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryMapper
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import com.iperovv.vkcourseproject.domain.model.AppSummary
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppSummaryRepositoryImpl @Inject constructor(
    private val appsApi: AppsApi,
    private val appSummaryMapper: AppSummaryMapper,
    private val dispatchers: CoroutineDispatchers,
) : AppSummaryRepository {
    override suspend fun getApps(): List<AppSummary> =
        withContext(dispatchers.io()) {
            val appSummaryListDto = appsApi.getAppList()
            val apps = appSummaryListDto.map { appSummaryMapper.fromDto(it) }
            return@withContext apps
        }
}
