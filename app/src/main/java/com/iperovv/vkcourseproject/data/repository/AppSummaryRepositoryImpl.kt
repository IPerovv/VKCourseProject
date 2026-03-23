package com.iperovv.vkcourseproject.data.repository

import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryMapper
import com.iperovv.vkcourseproject.di.qualifiers.IoDispatcher
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import com.iperovv.vkcourseproject.domain.model.AppSummary
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Suppress("ktlint:standard:class-signature")
class AppSummaryRepositoryImpl
    @Inject
    constructor(
        private val appsApi: AppsApi,
        private val appSummaryMapper: AppSummaryMapper,
        @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    ) : AppSummaryRepository {
        override suspend fun getApps(): List<AppSummary> =
            withContext(ioDispatcher) {
                val appSummaryListDto = appsApi.getAppList()
                val apps = appSummaryListDto.map { appSummaryMapper.fromDto(it) }
                return@withContext apps
            }
    }
