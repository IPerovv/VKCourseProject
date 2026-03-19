package com.iperovv.vkcourseproject.data

import com.iperovv.vkcourseproject.data.remote.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryMapper
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import com.iperovv.vkcourseproject.domain.model.AppSummary
import javax.inject.Inject

class AppSummaryRepositoryImpl
    @Inject
    constructor(
        private val appsApi: AppsApi,
        private val appSummaryMapper: AppSummaryMapper,
    ) : AppSummaryRepository {
        override fun getApps(): List<AppSummary> {
            val appSummaryListDto = appsApi.getAppList()
            val apps = appSummaryListDto.items.map { appSummaryMapper.fromDto(it) }
            return apps
        }
    }
